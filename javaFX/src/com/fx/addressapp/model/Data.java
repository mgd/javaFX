package com.fx.addressapp.model;

import javafx.beans.property.*;

public class Data {

    private IntegerProperty time;
    private StringProperty uuid;
    private DoubleProperty speed;
    private DoubleProperty heading;
    private DoubleProperty distance;

    public Data() {

        this(null, null, null, null);
    }

    public Data(String uuid, Double speed, Double heading, Double distance) {

        this.uuid = new SimpleStringProperty(uuid);
        this.speed = new SimpleDoubleProperty(speed);
        this.heading = new SimpleDoubleProperty(heading);
        this.distance = new SimpleDoubleProperty(distance);
        this.time = new SimpleIntegerProperty(0);
    }

    public String getUuid() {
        return uuid.get();
    }

    public StringProperty uuidProperty() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid.set(uuid);
    }

    public double getSpeed() {
        return speed.get();
    }

    public DoubleProperty speedProperty() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed.set(speed);
    }

    public double getHeading() {
        return heading.get();
    }

    public DoubleProperty headingProperty() {
        return heading;
    }

    public void setHeading(double heading) {
        this.heading.set(heading);
    }

    public double getDistance() {
        return distance.get();
    }

    public DoubleProperty distanceProperty() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance.set(distance);
    }

    public void setTime(int time) {
        this.time.set(time);
    }

    public int getTime() {
        return time.get();
    }

    public IntegerProperty timeProperty() {
        return time;
    }
}
