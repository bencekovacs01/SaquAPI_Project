package saquapi.rest.login;

import javax.validation.constraints.NotNull;

import saquapi.rest.base.ResponseMessage;
import saquapi.services.base.InvocationProxy;
import saquapi.services.logger.LoggerService;
import saquapi.services.login.LoginService;
import saquapi.services.login.LoginServiceBean;

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
    public Response login(@NotNull LoginMsg loginMsg) {
        loginService = (LoginService) InvocationProxy.newInstance(new LoginServiceBean());
        return Response.ok(new ResponseMessage(loginService.login(loginMsg) ? "SUCCESS" : "FAILED")).build();
    }
}