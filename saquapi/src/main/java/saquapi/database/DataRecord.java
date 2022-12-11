package saquapi.database;

import java.util.Date;

public class DataRecord {
    int roomNumber;
    long coldWater;
    long hotWater;

    public DataRecord() {
    }

    public DataRecord(int roomNumber, long coldWater, long hotWater) {
        this.roomNumber = roomNumber;
        this.coldWater = coldWater;
        this.hotWater = hotWater;
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
