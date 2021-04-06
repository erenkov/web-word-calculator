package com.erenkov.wws.utils;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * It is a simple utility logger.
 */
public class SimpleLogger {

    static private Logger simpleLogger;

    static { //конфигурация из файла log.config
        try (FileInputStream ins = new FileInputStream("log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            simpleLogger = Logger.getLogger(SimpleLogger.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method prints a info-msg to a log file
     *
     * @param msg message
     */
    public static void logInfo(String msg) {
        try {
            simpleLogger.log(Level.INFO, msg);
        } catch (Exception e) {
            simpleLogger.log(Level.WARNING, "logException (logInfo)", e);
        }
    }

    /**
     * This method prints a warning-msg to a log file
     *
     * @param msg message
     */
    public static void logWarning(String msg) {
        try {
            simpleLogger.log(Level.WARNING, msg);
        } catch (Exception e) {
            simpleLogger.log(Level.WARNING, "logException (logWarning)", e);
        }
    }

    /**
     * This method prints a label-msg to a log file (tracer-unit)
     *
     * @param msg message
     */
    public static void logLabel(String msg) {
        try {
            simpleLogger.log(Level.INFO, "========================  " + msg + "  ========================");
        } catch (Exception e) {
            simpleLogger.log(Level.WARNING, "logException (logLabel)", e);
        }
    }

}
