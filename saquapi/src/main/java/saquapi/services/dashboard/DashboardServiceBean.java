package saquapi.services.dashboard;

import saquapi.database.ResponseDataRecord;
import saquapi.database.DatabaseConnection;
import saquapi.database.RequestResponseDataRecord;
import saquapi.rest.login.LoginMsg;

import java.time.LocalDateTime;
import java.sql.Date;
import java.util.List;


public class DashboardServiceBean implements DashboardService{

    public void changePassword(LoginMsg loginMsg){
        DatabaseConnection.changeUserPassword(loginMsg.getRoomNumber(),loginMsg.getPassword());
    }

    public List<ResponseDataRecord> getAllRooms(){
        return null;
    }

    public Boolean insertData(RequestResponseDataRecord requestDataRecord){
        LocalDateTime now = LocalDateTime.now();
        Date date = new Date(now.getYear()-1900,now.getMonthValue()-1,now.getDayOfMonth());
        try{
            DatabaseConnection.insertData(requestDataRecord.getRoomNumber(), requestDataRecord.getColdWater(), requestDataRecord.getHotWater(), date, requestDataRecord.getFileInputStream());
        }catch (RuntimeException e){
            return false;
        }
        return true;
    }
}
