package saquapi.rest.login;

import javax.validation.constraints.NotNull;
import saquapi.services.logger.LoggerService;
import saquapi.services.login.LoginService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @Inject
    LoginService loginService;

    @Path("/")
    @POST
    @Produces("application/json")
    public LoginMsg login(@NotNull LoginMsg loginMsg) throws Exception {
        return loginService.login(loginMsg);
    }
}