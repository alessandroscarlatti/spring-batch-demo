package com.scarlatti.springbatchdemo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Tuesday, 7/31/2018
 */
public class SillyJobListener implements JobExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(SillyJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("SillyJobListener.beforeJob() jobExecution = [{}]", jobExecution);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("SillyJobListener.afterJob() jobExecution = [{}]", jobExecution);
    }
}
