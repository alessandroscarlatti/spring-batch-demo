package com.scarlatti.springbatchdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
public class NoOpBatchConfig {

    private static final Logger log = LoggerFactory.getLogger(NoOpBatchConfig.class);

    @Bean(BeanNames.Launcher)
    CommandLineRunner launcher() {
        return (String... args) -> {
            log.info("NoOpBatch running.");
            log.info("NoOpBatch complete.");
        };
    }
}
