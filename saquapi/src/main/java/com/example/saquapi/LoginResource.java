package com.example.saquapi;

import com.saquapi.login.Login;
import com.sun.istack.internal.NotNull;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @Path("/")
    @POST
    @Produces("application/json")
    public Response login(@NotNull Login login) {
        return Response.ok(login).build();
    }
}