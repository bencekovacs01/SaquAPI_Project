package saquapi.services.dashboard;

import saquapi.database.DatabaseConnection;
import saquapi.database.RequestDataRecord;
import saquapi.database.ResponseDataRecord;
import saquapi.rest.dashboard.UpdateRequestMsg;
import saquapi.rest.login.LoginMsg;

import java.time.LocalDateTime;
import java.sql.Date;
import java.util.List;


public class DashboardServiceBean implements DashboardService {

    public Boolean changePassword(LoginMsg loginMsg) {
        return DatabaseConnection.changeUserPassword(loginMsg.getRoomNumber(), loginMsg.getPassword());
    }

    public List<ResponseDataRecord> getAllRooms() {
        return null;
    }

    public Boolean insertData(RequestDataRecord requestDataRecord) {
        try{
            requestDataRecord.setBase64StringImage(requestDataRecord.getBase64StringImage().substring(23));
        }catch (NullPointerException e){
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        Date date = new Date(now.getYear() - 1900, now.getMonthValue() - 1, now.getDayOfMonth());
        try {
            DatabaseConnection.insertData(requestDataRecord.getRoomNumber(), requestDataRecord.getColdWater(), requestDataRecord.getHotWater(), date, requestDataRecord.getBase64StringImage());
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    public List<ResponseDataRecord> getAllRoomsWithData() {
        try {
            return DatabaseConnection.listAll();
        } catch (RuntimeException e) {
            return null;
        }
    }

    public List<ResponseDataRecord> getRoomData(int roomNumber) {
        try {
            return DatabaseConnection.listRoomData(roomNumber);
        } catch (RuntimeException e) {
            return null;
        }
    }

    public byte[] getImage(int key) {
        try {
            return DatabaseConnection.getImage(key);
        } catch (RuntimeException e) {
            return null;
        }
    }

    public Boolean updateData(UpdateRequestMsg updateRequestMsg) {
        try {
            return DatabaseConnection.updateData(updateRequestMsg.getKey(),updateRequestMsg.getColdWater(), updateRequestMsg.getHotWater());
        } catch (RuntimeException e) {
            return false;
        }
    }
}
