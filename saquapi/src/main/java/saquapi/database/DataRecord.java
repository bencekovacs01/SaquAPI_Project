package saquapi.database;

import java.util.Date;

public class DataRecord {
    int roomNumber;
    long coldWater;
    long hotWater;
    Date date;

    public DataRecord() {
    }

    public DataRecord(int roomNumber, long coldWater, long hotWater) {
        this.roomNumber = roomNumber;
        this.coldWater = coldWater;
        this.hotWater = hotWater;
    }

    public DataRecord(int roomNumber, long coldWater, long hotWater, Date date) {
        this.roomNumber = roomNumber;
        this.coldWater = coldWater;
        this.hotWater = hotWater;
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long getColdWater() {
        return coldWater;
    }

    public void setColdWater(long coldWater) {
        this.coldWater = coldWater;
    }

    public long getHotWater() {
        return hotWater;
    }

    public void setHotWater(long hotWater) {
        this.hotWater = hotWater;
    }
}
