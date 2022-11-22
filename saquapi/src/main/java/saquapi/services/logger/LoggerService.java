package saquapi.services.logger;

//import java.util.logging.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface LoggerService {
    void info(String message);
    void warning(String message);
    void error(String message);
}
