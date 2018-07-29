package com.scarlatti.springbatchdemo.listener;

import com.scarlatti.springbatchdemo.exception.SkipProcessingStringException;
import com.scarlatti.springbatchdemo.service.QueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
@Component
public class StringProcessorListener implements ItemProcessListener<String, String> {

    private static final Logger log = LoggerFactory.getLogger(StringProcessorListener.class);
    private QueueService queueService;


    public StringProcessorListener(QueueService queueService) {
        this.queueService = queueService;
    }

    @Override
    public void beforeProcess(String item) {

    }

    @Override
    public void afterProcess(String item, String result) {

    }

    @Override
    public void onProcessError(String string, Exception e) {

        if (e instanceof SkipProcessingStringException) {
            log.error("Observed error!");
            System.out.println("item = [" + string + "], ex = [" + e + "]");
            log.error("Error transforming string {}", string);
            queueService.writeToErrorQueue(string);
        }
    }
}
