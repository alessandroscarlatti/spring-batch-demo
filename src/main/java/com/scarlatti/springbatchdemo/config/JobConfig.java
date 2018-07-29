package com.scarlatti.springbatchdemo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 2/24/2018
 */
@Configuration
public class JobConfig {

    public static final String JobSelectionProperty = "springbatchdemo.job";

    private final JobBuilderFactory jobBuilderFactory;
    private final Step step1;
    private final Step step2;
    private final Step failureStep;

    public JobConfig(JobBuilderFactory jobBuilderFactory,
                     @Qualifier(BeanNames.Step1) Step step1,
                     @Qualifier(BeanNames.Step2) Step step2,
                     @Qualifier(BeanNames.FailureStep) Step failureStep) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.step1 = step1;
        this.step2 = step2;
        this.failureStep = failureStep;
    }

    @Bean(BeanNames.JobSelection)
    String jobSelection(Environment environment) {
        return environment.getProperty(JobSelectionProperty, BeanNames.ShortJob);
    }

    @Bean
    public Job job(@Qualifier(BeanNames.JobSelection) String jobSelection) {
        switch (jobSelection) {
            case BeanNames.ShortJob:
                return shortJob();
            case BeanNames.LongJob:
                return longJob();
            case BeanNames.FailureJob:
                return failureJob();
            default:
                throw new IllegalArgumentException("Unrecognized job selection: " + jobSelection);
        }
    }

    private Job shortJob() {
        return jobBuilderFactory
            .get(BeanNames.ShortJob)
            .start(step1)
            .build();
    }

    private Job longJob() {
        return jobBuilderFactory
            .get(BeanNames.LongJob)
            .start(step1)
            .next(step2)
            .build();
    }

    private Job failureJob() {
        return jobBuilderFactory
            .get(BeanNames.FailureJob)
            .start(step1)
            .next(failureStep)
            .next(step2)
            .build();
    }

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 45;
    }
}
