package saquapi.services.login;

import saquapi.rest.base.ResponseMessage;
import saquapi.rest.login.LoginMsg;
import saquapi.database.DatabaseConnection;

public class LoginServiceBean implements LoginService {

    @Override
    public Boolean login(LoginMsg loginMsg) {
        try {
            return DatabaseConnection.loginCredentials(loginMsg.getRoomNumber(), loginMsg.getPassword());
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public LoginMsg logout() {
        return null;
    }

}
