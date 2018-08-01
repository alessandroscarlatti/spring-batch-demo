package com.scarlatti.springbatchdemo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.support.CommandLineJobRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Batch {

    //	private static final Logger log = LoggerFactory.getLogger(Batch.class);
//
    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(Batch.class, args)));
    }

//	public static void main(String[] args) throws Exception {
//
//		CommandLineJobRunner.main(args);
//	}
}
