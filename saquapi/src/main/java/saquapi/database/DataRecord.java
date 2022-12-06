package saquapi.database;

public class DataRecord {

    int key;
    int roomNumber;
    long coldWater;
    long hotWater;

    public DataRecord() {
    }

    public DataRecord(int key, int roomNumber, long coldWater, long hotWater) {
        this.key = key;
        this.roomNumber = roomNumber;
        this.coldWater = coldWater;
        this.hotWater = hotWater;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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
