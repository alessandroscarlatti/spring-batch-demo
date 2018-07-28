package com.scarlatti.springbatchdemo;

import com.scarlatti.springbatchdemo.config.BeanNames;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 2/24/2018
 */
@Component(BeanNames.Launcher)
public class Launcher implements CommandLineRunner {

    private JobLauncher jobLauncher;
    private Job job;

    public Launcher(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @Override
    public void run(String... args) throws Exception {
        jobLauncher.run(job, newJobParams());
    }

    public static JobParameters newJobParams() {
        Map<String, JobParameter> params = new HashMap<>();
        long ts = ZonedDateTime.now(ZoneId.of("UTC")).toInstant().toEpochMilli();
        params.put("startTime", new JobParameter(ts));

        return new JobParameters(params);
    }
}
