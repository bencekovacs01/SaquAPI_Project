package saquapi.database;

import java.io.FileInputStream;

public class RequestDataRecord extends DataRecord {

    public FileInputStream fileInputStream;

    public RequestDataRecord() {
    }

    public RequestDataRecord(int key, int roomNumber, long coldWater, long hotWater, FileInputStream fileInputStream) {
        super(key, roomNumber, coldWater, hotWater);
        this.fileInputStream = fileInputStream;
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }
}
