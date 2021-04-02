package com.erenkov.wws.utils;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SimpleLogger {

    static Logger simpleLogger;

    static {
        try(FileInputStream ins = new FileInputStream("log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            simpleLogger = Logger.getLogger(SimpleLogger.class.getName());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void logInfo(String msg) {
        try {
            simpleLogger.log(Level.INFO, msg);
        } catch (Exception e){
            simpleLogger.log(Level.WARNING,"logException (logInfo)" , e);
        }
    }

    public static void logWarning(String msg) {
        try {
            simpleLogger.log(Level.WARNING,msg);
        }catch (Exception e){
            simpleLogger.log(Level.WARNING,"logException (logWarning)" , e);
        }
    }

    public static void logLabel(String msg) {
        try {
            simpleLogger.log(Level.INFO, "========================  " + msg + "  ========================");
        } catch (Exception e){
            simpleLogger.log(Level.WARNING,"logException (logLabel)" , e);
        }
    }

}
