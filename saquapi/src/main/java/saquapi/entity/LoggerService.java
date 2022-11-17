package saquapi.entity;

import java.util.logging.Logger;

public class LoggerService {
    Logger logger;

//    public LoggerService(){
//        StackTraceElement ste = new Throwable().getStackTrace()[1];
//        System.out.println(ste);
//    }

    public void log(String message){
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String callerClass = ste.getClassName();
        String callerMethod = ste.getMethodName();
        logger = Logger.getLogger(callerClass);
//        TODO: Bence: get log type as param
        logger.info(callerMethod + "() => " + message);
    }
}
