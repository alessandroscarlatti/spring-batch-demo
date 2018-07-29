package com.scarlatti.springbatchdemo.listener;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Sunday, 7/29/2018
 */
@Component
public class StringWriteListener implements ItemWriteListener<String> {

    @Override
    public void beforeWrite(List<? extends String> items) {

    }

    @Override
    public void afterWrite(List<? extends String> items) {

    }

    @Override
    public void onWriteError(Exception exception, List<? extends String> items) {
        System.out.println("Error writing");
        System.out.println("exception = [" + exception + "], items = [" + items + "]");
    }
}
