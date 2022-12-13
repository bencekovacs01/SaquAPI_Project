package saquapi.rest.hello;

import saquapi.services.logger.LoggerService;

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
//        loggerService.info("HELLO!");
//        DatabaseConnection.estabilishConnection();
//        List<DataRecord> list = DatabaseConnection.listAll();
//
//        for (DataRecord dr : list){
//            System.out.println(dr);
//        }
//
//        DatabaseConnection.closeConnection();

        return "Hello, SaquAPI! :)";
    }
}