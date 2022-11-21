package saquapi.services.login;

import saquapi.rest.login.LoginMsg;
import saquapi.services.logger.LoggerService;

import javax.inject.Inject;

public class LoginServiceBean implements LoginService{

    @Inject
    LoggerService loggerService;

    @Override
    public LoginMsg login(LoginMsg loginMsg) throws Exception {
        loggerService.info("Logging in...");
        if (!authentication(loginMsg)){
            // TODO:Bence: alert log
            throw new Exception("Wrong credentials!");
        }
        loggerService.info(loginMsg.toString());
        return loginMsg;
    }

    @Override
    public LoginMsg logout() throws Exception {
        return null;
    }

    private Boolean authentication(LoginMsg loginMsg){
        if (!userExists(loginMsg.getUserName())){
            loggerService.info("Wrong username!");
            return false;
        }
        return passwordsMatch(loginMsg.getPassword());
    }

    private Boolean passwordsMatch(String hashedPassword){
//        loggerService.info("Wrong password!");
        // DB query
        return true;
    }

    private Boolean userExists(String userName){
        // DB query
        return true;
    }

}
