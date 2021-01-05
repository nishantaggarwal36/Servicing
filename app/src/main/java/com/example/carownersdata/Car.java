package com.example.carownersdata;

import java.util.ArrayList;

public class Car {

    private String carname;
    private String cardetail;
    private String name;
    private String number;
    private String preferences;

    public Car(String carname, String cardetail, String name, String number, String preferences) {
        this.carname = carname;
        this.cardetail = cardetail;
        this.name = name;
        this.number = number;
        this.preferences = preferences;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCardetail() {
        return cardetail;
    }

    public void setCardetail(String cardetail) {
        this.cardetail = cardetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}
