package com.scarlatti.springbatchdemo.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
public class SingleLayerTaskletOrientedProcessing implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(SingleLayerTaskletOrientedProcessing.class);

    public static void main(String[] args) {
        new SingleLayerTaskletOrientedProcessing().run();
    }

    /**
     * Process a list of strings.
     * Simplifying a complex filter, filter out all strings containing "z".
     * Suppose that strings with numbers cause errors?
     * Now save each string to the database.
     */
    @Override
    public void run() {
        List<String> strings = getRawStrings();
        List<String> filteredStrings = new ArrayList<>();
        for (String string : strings) {
            if (!string.toUpperCase().contains("Z")) {
                filteredStrings.add(string);
            }
        }

        String result = StringUtils.collectionToDelimitedString(filteredStrings, ",");

        // assumed to be transactional...
        saveToDatabase(result);
    }

    private List<String> getRawStrings() {
        return Arrays.asList(
            "asdf",
            "qwer",
            "zxcv",  // this should be filtered out
            "sdfg"
        );
    }

    private void saveToDatabase(String string) {
        log.info("saving string {} to database", string);
    }
}
