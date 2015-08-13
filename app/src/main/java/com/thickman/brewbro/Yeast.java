package com.thickman.brewbro;

public class Yeast {

    private String name;
    private String type;
    private String form;
    private String manufacturer;
    private int minTemp;
    private int maxTemp;
    private String flocculation;

    public Yeast() {
        this.name = this.type = this.form = this.manufacturer = this.flocculation = "";
        this.minTemp = this.maxTemp = 0;
    }

    public Yeast(String name, String type, String form, String manufacturer, int minTemp, int maxTemp, String flocculation, int attenuation, String notes) {
        this.name = name;
        this.type = type;
        this.form = form;
        this.manufacturer = manufacturer;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.flocculation = flocculation;
        this.attenuation = attenuation;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getFlocculation() {
        return flocculation;
    }

    public void setFlocculation(String flocculation) {
        this.flocculation = flocculation;
    }

    public int getAttenuation() {
        return attenuation;
    }

    public void setAttenuation(int attenuation) {
        this.attenuation = attenuation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    private int attenuation;
    private String notes;


}

