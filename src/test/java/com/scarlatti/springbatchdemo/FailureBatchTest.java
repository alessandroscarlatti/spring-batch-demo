package com.scarlatti.springbatchdemo;

import com.scarlatti.springbatchdemo.config.BeanNames;
import com.scarlatti.springbatchdemo.config.JobConfig;
import com.scarlatti.springbatchdemo.config.NoOpBatchConfig;
import com.scarlatti.springbatchdemo.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Batch.class, NoOpBatchConfig.class, TestConfig.class})
public class FailureBatchTest {

	@Autowired
	JobLauncherTestUtils jobLauncherTestUtils;

	{
		System.setProperty(JobConfig.JobSelectionProperty, BeanNames.FailureJob);
	}

	@Test
	public void executeFailureBatch() throws Exception {
		jobLauncherTestUtils.launchJob(Launcher.newJobParams());
	}
}
