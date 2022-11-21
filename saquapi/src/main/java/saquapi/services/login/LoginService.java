package saquapi.services.login;

import saquapi.rest.login.LoginMsg;
import saquapi.services.logger.LoggerService;

import javax.inject.Inject;

public interface LoginService {
    LoginMsg login(LoginMsg loginMsg) throws Exception;
    LoginMsg logout() throws Exception;
}
