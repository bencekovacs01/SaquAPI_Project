package saquapi.services.login;

import saquapi.rest.base.ResponseMessage;
import saquapi.rest.login.LoginMsg;
import saquapi.services.logger.LoggerService;

import javax.inject.Inject;

public interface LoginService {
    Boolean login(LoginMsg loginMsg);

    LoginMsg logout() throws Exception;
}
