package saquapi.services.dashboard;

import saquapi.database.DataRecord;
import saquapi.database.RequestDataRecord;
import saquapi.database.ResponseDataRecord;
import saquapi.rest.login.LoginMsg;

import java.util.List;

public interface DashboardService {

    void changePassword(LoginMsg loginMsg);

    List<ResponseDataRecord> getAllRooms();

    Boolean insertData(RequestDataRecord dataRecord);

    List<ResponseDataRecord> getAllRoomsWithData();

    List<ResponseDataRecord> getRoomData(int roomNumber);

    byte[] getImage(int key);
}
