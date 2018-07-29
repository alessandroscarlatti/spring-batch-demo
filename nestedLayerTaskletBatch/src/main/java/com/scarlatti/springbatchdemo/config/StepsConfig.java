package com.scarlatti.springbatchdemo.config;

import com.scarlatti.springbatchdemo.tasklet.StringifyTasklet;
import org.springframework.batch.core.Step;
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

    @Bean
    Step step1(StringifyTasklet tasklet) {
        return stepBuilderFactory
            .get(BeanNames.Step1)
            .tasklet(tasklet)
            .build();
    }
}