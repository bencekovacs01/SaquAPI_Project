package saquapi.database;

public class ResponseDataRecord extends DataRecord {
    int key;

    public ResponseDataRecord(int key, int roomNumber, long coldWater, long hotWater ) {
        super(roomNumber, coldWater, hotWater);
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}
