package saquapi.rest.login;

import javax.validation.constraints.NotNull;
import saquapi.entity.LoggerService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @Inject
    LoggerService loggerService;

    @Path("/")
    @POST
    @Produces("application/json")
    public Response login(@NotNull LoginMsg loginMsg) {
//        loggerService.log("");
        return Response.ok(loginMsg).build();
    }
}