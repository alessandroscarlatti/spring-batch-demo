package com.scarlatti.springbatchdemo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Batch {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(Batch.class, args)));
	}
}
