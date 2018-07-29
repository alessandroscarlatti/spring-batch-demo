package com.scarlatti.springbatchdemo.exception;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 7/28/2018
 */
public class SkipProcessingStringException extends RuntimeException {
    public SkipProcessingStringException() {
        super();
    }

    public SkipProcessingStringException(String message) {
        super(message);
    }

    public SkipProcessingStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public SkipProcessingStringException(Throwable cause) {
        super(cause);
    }
}
