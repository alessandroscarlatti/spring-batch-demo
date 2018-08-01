package com.scarlatti.springbatchdemo.listener;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.autoconfigure.batch.JobExecutionEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Tuesday, 7/31/2018
 */
@Component
public class JobExecutionExitCodeGenerator implements ApplicationListener<JobExecutionEvent>, ExitCodeGenerator {

    private JobExecutionEvent jobExecutionEvent;

    @Override
    public void onApplicationEvent(JobExecutionEvent event) {
        this.jobExecutionEvent = event;
    }

    @Override
    public int getExitCode() {
        return jobExecutionEvent.getJobExecution().getStatus().ordinal();
    }

}
