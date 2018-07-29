package com.scarlatti.springbatchdemo.config;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
public interface BeanNames {
    String Launcher = "launcher";
    String JobSelection = "jobSelection";

    String ShortJob = "shortJob";
    String LongJob = "longJob";
    String FailureJob = "failureJob";

    String Step1 = "step1";
    String Step2 = "step2";
    String FailureStep = "failureStep";
}
