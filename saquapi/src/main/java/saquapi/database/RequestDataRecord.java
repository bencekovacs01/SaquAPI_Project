package saquapi.database;

import java.io.FileInputStream;

public class RequestDataRecord extends DataRecord {

    public String base64StringImage;

    public RequestDataRecord() {
    }

    public RequestDataRecord(int roomNumber, long coldWater, long hotWater, String base64StringImage) {
        super(roomNumber, coldWater, hotWater);
        this.base64StringImage = base64StringImage;
    }

    public String getBase64StringImage() {
        return base64StringImage;
    }

    public void setBase64StringImage(String base64StringImage) {
        this.base64StringImage = base64StringImage;
    }
}
