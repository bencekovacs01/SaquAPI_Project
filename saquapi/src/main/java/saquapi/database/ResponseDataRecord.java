package saquapi.database;

import java.time.LocalDate;

public class ResponseDataRecord extends DataRecord{

    int key;

    LocalDate date;

    public ResponseDataRecord() {
    }

    public ResponseDataRecord(int key, int roomNumber, long coldWater, long hotWater, LocalDate date) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
