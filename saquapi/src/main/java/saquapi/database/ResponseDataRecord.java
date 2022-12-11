package saquapi.database;

import java.sql.Date;

public class ResponseDataRecord extends DataRecord{

    int key;

    Date date;

    public ResponseDataRecord() {
    }

    public ResponseDataRecord(int key, int roomNumber, long coldWater, long hotWater, Date date) {
        super(roomNumber, coldWater, hotWater);
        this.key = key;
        this.date = date;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
