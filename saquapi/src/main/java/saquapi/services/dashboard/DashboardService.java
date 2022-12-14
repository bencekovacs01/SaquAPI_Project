package saquapi.services.dashboard;

import saquapi.database.RequestDataRecord;
import saquapi.database.ResponseDataRecord;
import saquapi.rest.dashboard.UpdateRequestMsg;
import saquapi.rest.login.LoginMsg;

import java.util.List;

public interface DashboardService {

    Boolean changePassword(LoginMsg loginMsg);

    List<ResponseDataRecord> getAllRooms();

    Boolean insertData(RequestDataRecord dataRecord);

    List<ResponseDataRecord> getAllRoomsWithData();

    List<ResponseDataRecord> getRoomData(int roomNumber);

    String getImage(int key);

    Boolean updateData(UpdateRequestMsg updateRequestMsg);
}
