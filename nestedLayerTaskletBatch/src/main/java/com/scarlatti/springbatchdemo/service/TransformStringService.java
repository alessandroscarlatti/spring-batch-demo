package com.scarlatti.springbatchdemo.service;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
@Component
public class TransformStringService {

    private int transformStringInvocationCount = -1;

    /**
     * Issue an exception on a random string!
     * @param original the original string
     * @return the original string, repeated
     */
    public String tryTransformString(String original) {
        transformStringInvocationCount++;
        int random = new Random(System.currentTimeMillis()).nextInt(2);

        if (transformStringInvocationCount % 2 == random) {
            throw new RuntimeException("Unable to reach transformation service for string " + original);
        } else {
            return original + original;
        }
    }
}
