package com.scarlatti.springbatchdemo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
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
@EnableBatchProcessing
public class Config {
    private JobBuilderFactory jobBuilders;
    private StepBuilderFactory stepBuilders;

    public Config(JobBuilderFactory jobBuilders, StepBuilderFactory stepBuilders) {
        this.jobBuilders = jobBuilders;
        this.stepBuilders = stepBuilders;
    }

    @Bean
    public Job customerReportJob() {
        return jobBuilders.get("customerReportJob")
            .start(taskletStep())
            .build();
    }

    @Bean("my cool step")
    public Step taskletStep() {
        return stepBuilders.get("my amazing tasklet")
            .tasklet(tasklet())
            .build();
    }

    @Bean
    public Tasklet tasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("hello");
            return RepeatStatus.FINISHED;
        };
    }
}
