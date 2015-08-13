package com.thickman.brewbro;

import android.util.Log;

public class HopAddition {
    private Hop hop;
    private int time;
    private float weight;

    public HopAddition() {
        this.hop = new Hop();
        this.time = 0;
        this.weight = 0.0f;
    }

    public HopAddition(Hop hop, int time, float weight) {
        this.hop = hop;
        this.time = time;
        this.weight = weight;
    }

    public double getIBURager(float volume, float gravity) {
        return (weight * getUtilizationRager() * hop.getAlpha() * 7462)/((volume) * (1 + getGravityAdjustmentRager(gravity)));
    }

    private double getUtilizationRager() {
        return (18.11 + (13.86 * Math.tanh((time - 31.32) / 18.27))) / 100;
    }

    private double getGravityAdjustmentRager(float gravity) {
        return (gravity - 1.050)/0.2;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Hop getHop() {
        return hop;
    }

    public void setHop(Hop hop) {
        this.hop = hop;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}