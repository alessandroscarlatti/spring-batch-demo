package com.scarlatti.springbatchdemo.config;

import com.scarlatti.springbatchdemo.listener.SillyJobListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class JobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    public JobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job job(@Qualifier(BeanNames.Step1) Step step1,
                   @Qualifier(BeanNames.Step2) Step step2,
                   @Qualifier(BeanNames.Step3) Step step3) {
        return jobBuilderFactory
            .get(BeanNames.Job)
            .listener(new SillyJobListener())
            .start(step1)
            .next(step2)
            .next(step3)
            .build();
    }
}
