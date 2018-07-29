package com.scarlatti.springbatchdemo.processor;

import com.scarlatti.springbatchdemo.exception.SkipProcessingStringException;
import com.scarlatti.springbatchdemo.service.TransformStringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
@Component
public class StringProcessor implements ItemProcessor<String, String> {

    private TransformStringService transformStringService;
    private static final Logger log = LoggerFactory.getLogger(StringProcessor.class);

    public StringProcessor(TransformStringService transformStringService) {
        this.transformStringService = transformStringService;
    }

    @Override
    public String process(String string) {
        try {
            return transformStringService.tryTransformString(string);
        } catch (Exception e) {
            throw new SkipProcessingStringException("Skip processing string " + string, e);
        }
    }
}
