package com.scarlatti.springbatchdemo.writer;

import com.scarlatti.springbatchdemo.exception.SkipProcessingStringException;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
@Component
public class StringWriter implements ItemWriter<String> {

    private List<String> strings;

    public StringWriter(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public void write(List<? extends String> items) throws Exception {
        System.out.println("writing items = [" + items + "]");
        strings.addAll(items);
        throw new SkipProcessingStringException("asdf");
    }
}
