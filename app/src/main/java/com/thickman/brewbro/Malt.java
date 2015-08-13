package com.thickman.brewbro;

public class Malt {

    private String name;
    private String origin;
    private String type;
    private float color;
    private boolean mustMash;
    private float potentialSG;
    private float maxInBatch;

    public Malt() {
        this.name = "";
        this.origin = "";
        this.type = "";
        this.color = 0.0f;
        this.mustMash = true;
        this.potentialSG = 0.0f;
        this.maxInBatch = 0.0f;
    }

    public Malt(String name, String origin, String type, float color, boolean mustMash, float potentialSG, float maxInBatch) {
        this.name = name;
        this.origin = origin;
        this.type = type;
        this.color = color;
        this.mustMash = mustMash;
        this.potentialSG = potentialSG;
        this.maxInBatch = maxInBatch;
    }

    public float getColor() {
        return color;
    }

    public void setColor(float color) {
        this.color = color;
    }

    public float getMaxInBatch() {
        return maxInBatch;
    }

    public void setMaxInBatch(float maxInBatch) {
        this.maxInBatch = maxInBatch;
    }

    public boolean isMustMash() {
        return mustMash;
    }

    public void setMustMash(boolean mustMash) {
        this.mustMash = mustMash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getPotentialSG() {
        return potentialSG;
    }

    public void setPotentialSG(float potentialSG) {
        this.potentialSG = potentialSG;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
