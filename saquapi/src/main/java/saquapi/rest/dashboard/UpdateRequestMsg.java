package saquapi.rest.dashboard;

public class UpdateRequestMsg {

    int key;
    long coldWater;
    long hotWater;

    public UpdateRequestMsg() {
    }

    public UpdateRequestMsg(int key, long coldWater, long hotWater) {
        this.key = key;
        this.coldWater = coldWater;
        this.hotWater = hotWater;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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
