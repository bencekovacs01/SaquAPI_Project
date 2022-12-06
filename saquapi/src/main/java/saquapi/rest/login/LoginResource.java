package saquapi.rest.login;

import javax.validation.constraints.NotNull;

import saquapi.services.base.InvocationProxy;
import saquapi.services.logger.LoggerService;
import saquapi.services.login.LoginService;
import saquapi.services.login.LoginServiceBean;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/login")
public class LoginResource {

    @Inject
    LoginService loginService;

    @Inject
    LoggerService loggerService;

    @Path("/")
    @POST
    @Produces("application/json")
    public LoginMsg login(@NotNull LoginMsg loginMsg) throws Exception {
        loginService = (LoginService) InvocationProxy.newInstance(new LoginServiceBean());
        return loginService.login(loginMsg);
    }
}