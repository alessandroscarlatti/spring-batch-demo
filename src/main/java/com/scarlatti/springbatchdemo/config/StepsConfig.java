package com.scarlatti.springbatchdemo.config;

import com.scarlatti.springbatchdemo.tasklet.DoMoreStuffTasklet;
import com.scarlatti.springbatchdemo.tasklet.DoStuffTasklet;
import com.scarlatti.springbatchdemo.tasklet.FailureTasklet;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean(BeanNames.Step1)
    public Step step1(DoStuffTasklet tasklet) {
        return stepBuilderFactory
            .get(BeanNames.Step1)
            .tasklet(tasklet)
            .build();
    }

    @Bean(BeanNames.Step2)
    public Step step2(DoMoreStuffTasklet tasklet) {
        return stepBuilderFactory
            .get(BeanNames.Step2)
            .tasklet(tasklet)
            .build();
    }

    @Bean(BeanNames.FailureStep)
    public Step stepFails(FailureTasklet tasklet) {
        return stepBuilderFactory
            .get(BeanNames.FailureStep)
            .tasklet(tasklet)
            .build();
    }

    @Bean
    StepExecutionListener stepExecutionListener() {
        return new StepExecutionListener() {
            @Override
            public void beforeStep(StepExecution stepExecution) {

            }

            @Override
            public ExitStatus afterStep(StepExecution stepExecution) {
                return new ExitStatus("asdf");
            }
        };
    }


}
