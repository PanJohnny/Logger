package com.panjohnny;

import java.util.HashMap;
import java.util.Map;

public class LoggerFinder extends System.LoggerFinder {

    private static final Map<String, Logger> LOGGERS = new HashMap<>();

    @Override
    public System.Logger getLogger(String name, Module module) {
        return LOGGERS.computeIfAbsent(name, Logger::new);
    }
}