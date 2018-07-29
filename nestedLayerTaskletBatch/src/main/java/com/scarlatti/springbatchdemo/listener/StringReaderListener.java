package com.scarlatti.springbatchdemo.listener;

import com.scarlatti.springbatchdemo.exception.SkipProcessingStringException;
import com.scarlatti.springbatchdemo.service.QueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
@Component
public class StringReaderListener implements ItemReadListener<String> {

    private static final Logger log = LoggerFactory.getLogger(StringReaderListener.class);
    private QueueService queueService;


    public StringReaderListener(QueueService queueService) {
        this.queueService = queueService;
    }

    @Override
    public void beforeRead() {

    }

    @Override
    public void afterRead(String item) {

    }

    @Override
    public void onReadError(Exception ex) {
        System.out.println("on read error:");
        System.out.println("ex = [" + ex + "]");
    }
}
