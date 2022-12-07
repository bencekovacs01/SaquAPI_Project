package saquapi.database;

import java.io.FileInputStream;

public class RequestDataRecord extends DataRecord {

    public FileInputStream fileInputStream;

    public RequestDataRecord() {
    }

    public RequestDataRecord(int roomNumber, long coldWater, long hotWater, FileInputStream fileInputStream) {
        super(roomNumber, coldWater, hotWater);
        this.fileInputStream = fileInputStream;
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }
}
