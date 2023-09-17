package com.example.geektrust.trainbogies;

public class Bogie {
    private String stationCode;
    private int absoluteDistFromSource;
    private int relativeDistFromHyd;

    public Bogie(String stationCode, int absoluteDistFromSource, int relativeDistFromHyd) {
        this.stationCode = stationCode;
        this.absoluteDistFromSource = absoluteDistFromSource;
        this.relativeDistFromHyd = relativeDistFromHyd;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public int getAbsoluteDistFromSource() {
        return absoluteDistFromSource;
    }

    public void setAbsoluteDistFromSource(int absoluteDistFromSource) {
        this.absoluteDistFromSource = absoluteDistFromSource;
    }

    public int getRelativeDistFromHyd() {
        return relativeDistFromHyd;
    }

    public void setRelativeDistFromHyd(int relativeDistFromHyd) {
        this.relativeDistFromHyd = relativeDistFromHyd;
    }
}
