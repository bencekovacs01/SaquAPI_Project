package saquapi.services.dashboard;

import saquapi.database.DataRecord;
import saquapi.rest.login.LoginMsg;

import java.util.List;

public interface DashboardService {

    void changePassword(LoginMsg loginMsg);

    List<DataRecord> getAllRooms();
}
