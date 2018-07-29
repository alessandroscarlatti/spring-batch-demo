package com.scarlatti.springbatchdemo.tasklet;

import com.scarlatti.springbatchdemo.service.QueueService;
import com.scarlatti.springbatchdemo.service.RawStringsService;
import com.scarlatti.springbatchdemo.service.StringDao;
import com.scarlatti.springbatchdemo.service.TransformStringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
@Component
public class StringifyTasklet implements Tasklet {

    private RawStringsService rawStringsService;
    private TransformStringService transformStringService;
    private StringDao stringDao;
    private QueueService queueService;

    private static final Logger log = LoggerFactory.getLogger(StringifyTasklet.class);

    public StringifyTasklet(RawStringsService rawStringsService, TransformStringService transformStringService, StringDao stringDao, QueueService queueService) {
        this.rawStringsService = rawStringsService;
        this.transformStringService = transformStringService;
        this.stringDao = stringDao;
        this.queueService = queueService;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        List<String> strings = rawStringsService.getRawStrings();
        List<String> filteredStrings = new ArrayList<>();
        for (String string : strings) {
            if (!string.toUpperCase().contains("Z")) {
                try {
                    String transformed = transformStringService.tryTransformString(string);
                    filteredStrings.add(transformed);
                } catch (Exception e) {
                    log.error("Error transforming string {}", string, e);
                    queueService.writeToErrorQueue(string);
                }
            }
        }

        String result = StringUtils.collectionToDelimitedString(filteredStrings, ",");
        stringDao.saveToDatabase(result);

        return RepeatStatus.FINISHED;
    }
}
