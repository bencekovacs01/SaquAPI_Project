package saquapi.database;

public class DataRecord {
    int key;
    int roomnumber;
    long coldWater;
    long hotWater;

    public DataRecord(int key, int roomnumber, long coldWater, long hotWater) {
        this.key = key;
        this.roomnumber = roomnumber;
        this.coldWater = coldWater;
        this.hotWater = hotWater;
    }
}
