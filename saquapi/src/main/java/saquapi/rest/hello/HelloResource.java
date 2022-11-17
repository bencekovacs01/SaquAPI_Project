package saquapi.rest.hello;

import saquapi.entity.LoggerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {

    @Inject
    LoggerService loggerService;

    @GET
    @Produces("text/plain")
    public String hello() {
//        Logger logger = Logger.getLogger(HelloResource.class.getName());a
//        logger.info("HI");
//        LoggerService loggerService = new LoggerService();
        loggerService.log("HI");
        return "Hello, SaquAPI! :)";
    }
}