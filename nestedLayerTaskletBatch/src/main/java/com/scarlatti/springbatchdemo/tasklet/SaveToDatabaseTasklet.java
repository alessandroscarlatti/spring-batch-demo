package com.scarlatti.springbatchdemo.tasklet;

import com.scarlatti.springbatchdemo.config.BeanNames;
import com.scarlatti.springbatchdemo.service.StringDao;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
@Component
public class SaveToDatabaseTasklet implements Tasklet {

    private List<String> transformedStrings;
    private StringDao stringDao;

    public SaveToDatabaseTasklet(@Qualifier(BeanNames.TransformedStrings) List<String> transformedStrings, StringDao stringDao) {
        this.transformedStrings = transformedStrings;
        this.stringDao = stringDao;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        String result = StringUtils.collectionToDelimitedString(transformedStrings, ",");
        stringDao.saveToDatabase(result);
        return RepeatStatus.FINISHED;
    }
}
