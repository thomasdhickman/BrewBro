package com.thickman.brewbro;

public class MaltAddition {

    private Malt malt;
    private float weight;
    private boolean mashed;

    public MaltAddition() {

    }

    public MaltAddition(Malt malt, float weight, boolean mashed) {
        this.malt = malt;
        this.weight = weight;
        this.mashed = mashed;
    }

    public double getMCU(float volume) {
        return (malt.getColor() * weight) / volume;
    }

    public Malt getMalt() {
        return malt;
    }

    public void setMalt(Malt malt) {
        this.malt = malt;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isMashed() {
        return mashed;
    }

    public void setMashed(boolean mashed) {
        this.mashed = mashed;
    }
}
