package com.thickman.brewbro;

public class Hop {

    private String name;
    private float alpha;
    private float beta;
    private float hsi;
    private float humulene;
    private float caryophyllene;
    private float cohumulone;
    private float myrcene;
    private String origin;
    private String substitutes;
    private String notes;

    public Hop() {
        this.name = this.notes = this.origin = this.substitutes = "";
        this.alpha = this.beta = this.hsi = this.humulene = this.caryophyllene = this.cohumulone = this.myrcene = 0.0f;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public float getBeta() {
        return beta;
    }

    public void setBeta(float beta) {
        this.beta = beta;
    }

    public float getHsi() {
        return hsi;
    }

    public void setHsi(float hsi) {
        this.hsi = hsi;
    }

    public float getHumulene() {
        return humulene;
    }

    public void setHumulene(float humulene) {
        this.humulene = humulene;
    }

    public float getCaryophyllene() {
        return caryophyllene;
    }

    public void setCaryophyllene(float caryophyllene) {
        this.caryophyllene = caryophyllene;
    }

    public float getCohumulone() {
        return cohumulone;
    }

    public void setCohumulone(float cohumulone) {
        this.cohumulone = cohumulone;
    }

    public float getMyrcene() {
        return myrcene;
    }

    public void setMyrcene(float myrcene) {
        this.myrcene = myrcene;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(String substitutes) {
        this.substitutes = substitutes;
    }
}