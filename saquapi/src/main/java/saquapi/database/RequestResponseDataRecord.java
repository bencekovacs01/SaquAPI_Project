package saquapi.database;

import java.io.FileInputStream;

public class RequestResponseDataRecord extends DataRecord {

    public FileInputStream fileInputStream;

    public RequestResponseDataRecord() {
    }

    public RequestResponseDataRecord(int roomNumber, long coldWater, long hotWater, FileInputStream fileInputStream) {
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
