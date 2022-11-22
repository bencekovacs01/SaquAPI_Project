package saquapi.services.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerServiceBean implements LoggerService {

    Logger logger;
    StackTraceElement ste;
    String callerClass;
    String callerMethod;
    String messageBody;

    private void init(){
        ste = new Throwable().getStackTrace()[2];
        callerClass = ste.getClassName();
        callerMethod = ste.getMethodName();
        messageBody = callerMethod + "() => ";
        logger = LoggerFactory.getLogger(callerClass);
    }

    public void info(String message){
        init();
        logger.info(messageBody + message);
    }

    public void warning(String message){
        init();
        logger.warn(messageBody + message);
    }

    public void error(String message){
        init();
        logger.error(messageBody + message);
    }

}
