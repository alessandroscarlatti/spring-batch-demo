package com.scarlatti.springbatchdemo.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
@Component
public class ListStringReader implements ItemReader<String> {

    private Queue<String> queue = new ArrayDeque<>(getRawStrings());

    /**
     * Read the next item.
     * @return the next item.  Null when finished reading.
     */
    @Override
    public String read() {
        return queue.poll();
    }

    private static List<String> getRawStrings() {
        return Arrays.asList(
            "asdf",
            "qwer",
            "zxcv",  // this should be filtered out
            "sdfg"
        );
    }
}
