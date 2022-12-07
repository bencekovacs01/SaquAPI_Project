package saquapi.database;

public class ResponseDataRecord extends DataRecord{

    int key;

    public ResponseDataRecord() {
    }

    public ResponseDataRecord(int key, int roomNumber, long coldWater, long hotWater) {
        super(roomNumber, coldWater, hotWater);
        this.key = key;
    }
}
