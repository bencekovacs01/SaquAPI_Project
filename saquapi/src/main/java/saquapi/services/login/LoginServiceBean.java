package saquapi.services.login;

import saquapi.rest.login.LoginMsg;
import saquapi.services.logger.LoggerService;
import saquapi.database.DatabaseConnection;

import javax.inject.Inject;

public class LoginServiceBean implements LoginService{

    @Inject
    LoggerService loggerService;

    @Override
    public LoginMsg login(LoginMsg loginMsg){
        loggerService.info("Logging in...");
        if (!authentication(loginMsg)){
            loggerService.error("Wrong login credentials!");
            return null;
        }
        loggerService.info(loginMsg.toString());
        return loginMsg;
    }

    @Override
    public LoginMsg logout() throws Exception {
        return null;
    }

    private Boolean authentication(LoginMsg loginMsg){
        if (!DatabaseConnection.loginCredentials(loginMsg.getRoomNumber(), loginMsg.getPassword())){
            return false;
        }
        return true;
    }

}
