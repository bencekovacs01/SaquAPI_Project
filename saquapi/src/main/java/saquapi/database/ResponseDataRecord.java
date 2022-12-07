package saquapi.database;

import java.sql.Date;

public class ResponseDataRecord extends DataRecord{

    int key;

    public ResponseDataRecord() {
    }

    public ResponseDataRecord(int key, int roomNumber, long coldWater, long hotWater, Date date) {
        super(roomNumber, coldWater, hotWater);
        this.key = key;
    }
}
