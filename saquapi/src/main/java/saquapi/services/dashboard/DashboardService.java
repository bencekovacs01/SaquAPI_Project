package saquapi.services.dashboard;

import saquapi.database.DataRecord;
import saquapi.database.RequestDataRecord;
import saquapi.rest.login.LoginMsg;

import java.util.List;

public interface DashboardService {

    void changePassword(LoginMsg loginMsg);

    List<DataRecord> getAllRooms();

    Boolean insertData(RequestDataRecord dataRecord);

    List<DataRecord> getAllRoomsWithData();

    List<DataRecord> getRoomData(int roomNumber);

    byte[] getImage(int key);
}
