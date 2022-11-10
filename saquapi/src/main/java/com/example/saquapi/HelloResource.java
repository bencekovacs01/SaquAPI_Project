package com.example.saquapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.logging.Logger;

@Path("/hello-world")
public class HelloResource {

    @GET
    @Produces("text/plain")
    public String hello() {
        Logger logger = Logger.getLogger(HelloResource.class.getName());
        logger.info("HI");
        return "Hello, SaquAPI! :)";
    }
}