package com.scarlatti.springbatchdemo.step1;

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
@Configuration("step1Config")
public class Config {

    private StepBuilderFactory stepBuilders;

    public Config(StepBuilderFactory stepBuilders) {
        this.stepBuilders = stepBuilders;
    }

    @Bean("step1")
    public Step step1(PrintStuff printStuff) {
        return stepBuilders.get("step1")
            .tasklet(printStuff)
            .build();
    }
}
