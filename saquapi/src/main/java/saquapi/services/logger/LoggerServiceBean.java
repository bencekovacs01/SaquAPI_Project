package saquapi.services.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerServiceBean implements LoggerService {

    Logger logger;

    public void info(String message){
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String callerClass = ste.getClassName();
        String callerMethod = ste.getMethodName();
        logger = LoggerFactory.getLogger(callerClass);
//        TODO: Bence: get log type as param
        logger.info(callerMethod + "() => " + message);
    }
}
