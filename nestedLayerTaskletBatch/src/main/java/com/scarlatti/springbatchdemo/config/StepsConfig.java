package com.scarlatti.springbatchdemo.config;

import com.scarlatti.springbatchdemo.exception.SkipProcessingStringException;
import com.scarlatti.springbatchdemo.listener.SpecialSkipPolicy;
import com.scarlatti.springbatchdemo.listener.StringProcessorListener;
import com.scarlatti.springbatchdemo.listener.StringReaderListener;
import com.scarlatti.springbatchdemo.listener.StringWriteListener;
import com.scarlatti.springbatchdemo.processor.StringProcessor;
import com.scarlatti.springbatchdemo.reader.ListStringReader;
import com.scarlatti.springbatchdemo.tasklet.SaveToDatabaseTasklet;
import com.scarlatti.springbatchdemo.tasklet.StringifyTasklet;
import com.scarlatti.springbatchdemo.writer.StringWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 2/24/2018
 */
@Configuration
public class StepsConfig {

    private StepBuilderFactory stepBuilderFactory;

    public StepsConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    Step step1(StringifyTasklet tasklet) {
        return stepBuilderFactory
            .get(BeanNames.Step1)
            .tasklet(tasklet)
            .build();
    }

    @Bean(BeanNames.Step2)
    Step step2(ListStringReader reader, StringProcessor processor, StringProcessorListener exceptionHandler, StringReaderListener readerListener, StringWriteListener writeListener, StringWriter writer, SpecialSkipPolicy skipPolicy) {
        return stepBuilderFactory
            .get(BeanNames.Step2)
            .<String, String>chunk(3)
            .reader(reader)
            .processor(processor)
            .listener(exceptionHandler)
            .faultTolerant()
            .skipLimit(4)
            .skip(IOException.class)
//            .skipPolicy(skipPolicy)
            .<String>writer(writer)
            .listener(readerListener)
            .listener(writeListener)
            .build();
    }

    @Bean(BeanNames.Step3)
    Step step3(SaveToDatabaseTasklet tasklet) {
        return stepBuilderFactory
            .get(BeanNames.Step3)
            .tasklet(tasklet)
            .build();
    }

    @Bean(BeanNames.TransformedStrings)
    List<String> transformedStrings() {
        return new ArrayList<>();
    }
}
