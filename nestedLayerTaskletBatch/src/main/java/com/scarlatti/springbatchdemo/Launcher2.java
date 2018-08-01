package com.scarlatti.springbatchdemo;

import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Tuesday, 7/31/2018
 */
@Component
public class Launcher2 extends JobLauncherCommandLineRunner {

    public Launcher2(JobLauncher jobLauncher, JobExplorer jobExplorer) {
        super(jobLauncher, jobExplorer);
    }

    @Override
    public void run(String... args) throws JobExecutionException {
        super.run(args);
    }
}
