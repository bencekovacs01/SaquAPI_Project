package saquapi.services.dashboard;

import saquapi.database.DataRecord;
import saquapi.database.DatabaseConnection;
import saquapi.rest.login.LoginMsg;

import javax.inject.Inject;
import java.util.List;

public class DashboardServiceBean implements DashboardService{

    public void changePassword(LoginMsg loginMsg){
        DatabaseConnection.changeUserPassword(loginMsg.getRoomNumber(),loginMsg.getPassword());
    }

    public List<DataRecord> getAllRooms(){
        return null;
    }
}
