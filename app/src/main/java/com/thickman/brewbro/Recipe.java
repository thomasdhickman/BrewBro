package com.thickman.brewbro;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private String name;
    private float batchSize;
    private float originalGravity;
    private float boilGravity;
    private float finalGravity;
    private Yeast yeast;
    private List<HopAddition> hopAdditionList;
    private List<MaltAddition> maltList;
    private List<String> specialIngredientsList;

    public Recipe() {
        this.name = "";
        this.batchSize = 5.0f;
        this.originalGravity = 1.0f;
        this.finalGravity = 1.0f;
        this.yeast = new Yeast();
        this.hopAdditionList = new ArrayList<HopAddition>();
        this.maltList = new ArrayList<MaltAddition>();
        this.specialIngredientsList = new ArrayList<String>();
    }

    public Recipe(String name, float batchSize, float originalGravity, float finalGravity, Yeast yeast, List<HopAddition> hopAdditionList, List<MaltAddition> maltList, List<String> specialIngredientsList) {
        this.name = name;
        this.batchSize = batchSize;
        this.originalGravity = originalGravity;
        this.finalGravity = finalGravity;
        this.yeast = yeast;
        this.hopAdditionList = hopAdditionList;
        this.maltList = maltList;
        this.specialIngredientsList = specialIngredientsList;
    }

    public double getABV() {
        return ((76.08 * (originalGravity - finalGravity) / (1.775 - originalGravity)) * (finalGravity / 0.794));
    }

    public double getIBURager() {
        double IBU = 0.0;
        for (int i = 0; i < hopAdditionList.size(); i++) {
            IBU += hopAdditionList.get(i).getIBURager(batchSize, boilGravity);
        }
        return IBU;
    }

    public double getSRM() {
        double SRM = 0.0;
        for (int i = 0; i < maltList.size(); i++) {
            SRM += (1.4922 * (Math.pow(maltList.get(i).getMCU(batchSize), 0.6859)));
        }
        return SRM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(float batchSize) {
        this.batchSize = batchSize;
    }

    public float getOriginalGravity() {
        return originalGravity;
    }

    public void setOriginalGravity(float originalGravity) {
        this.originalGravity = originalGravity;
    }

    public float getBoilGravity() {
        return boilGravity;
    }

    public void setBoilGravity(float boilGravity) {
        this.boilGravity = boilGravity;
    }

    public float getFinalGravity() {
        return finalGravity;
    }

    public void setFinalGravity(float finalGravity) {
        this.finalGravity = finalGravity;
    }

    public Yeast getYeast() {
        return yeast;
    }

    public void setYeast(Yeast yeast) {
        this.yeast = yeast;
    }

    public List<HopAddition> getHopAdditionList() {
        return hopAdditionList;
    }

    public void setHopAdditionList(List<HopAddition> hopAdditionList) {
        this.hopAdditionList = hopAdditionList;
    }

    public List<MaltAddition> getMaltList() {
        return maltList;
    }

    public void setMaltList(List<MaltAddition> maltList) {
        this.maltList = maltList;
    }

    public List<String> getSpecialIngredientsList() {
        return specialIngredientsList;
    }

    public void setSpecialIngredientsList(List<String> specialIngredientsList) {
        this.specialIngredientsList = specialIngredientsList;
    }

    public void addHop(HopAddition hop) {
        hopAdditionList.add(hop);
    }

    public void removeHop(HopAddition hop) {
        hopAdditionList.remove(hop);
    }

    public void addMalt(MaltAddition malt) {
        maltList.add(malt);
    }

    public void removeMalt(MaltAddition malt) {
        maltList.remove(malt);
    }

    public void addSpecialIngredient(String ingredient) {
        specialIngredientsList.add(ingredient);
    }

    public void removeSpecialIngredient(String ingredient) {
        specialIngredientsList.remove(ingredient);
    }

    public static Recipe getCentennialIPA() {
        Recipe r = new Recipe();

        r.name = "Centennial IPA";
        r.batchSize = 5.0f;
        r.originalGravity = 1.055f;
        r.boilGravity = 1.045f;
        r.finalGravity = 1.010f;

        Hop c = new Hop();
        c.setName("Centennial");
        c.setAlpha(0.103f);
        c.setName("Medium with floral and citrus tones.");

        HopAddition h60 = new HopAddition(c, 60, 2);
        HopAddition h30 = new HopAddition(c, 30, 1);
        HopAddition h15 = new HopAddition(c, 15, 1);
        HopAddition h0  = new HopAddition(c,  0, 1);

        List<HopAddition> hops = new ArrayList<HopAddition>();
        hops.add(h60);
        hops.add(h30);
        hops.add(h15);
        hops.add(h0);

        r.hopAdditionList = hops;

        Malt twoRow = new Malt("Pale (2-row)", "US", "Grain", 2, true, 1.036f, 1);
        Malt carapils = new Malt("Carapils/Dextrine", "US", "Grain", 2, false, 1.033f, 0.2f);
        Malt crystal20 = new Malt("Caramel/Crystal Malt - 20L", "US", "Grain", 20, false, 1.035f, 0.2f);
        Malt vienna = new Malt("Vienna", "DE", "Grain", 2, true, 1.04f, 0.6f);

        MaltAddition ma1 = new MaltAddition(twoRow, 9.5f, true);
        MaltAddition ma2 = new MaltAddition(carapils, 1, true);
        MaltAddition ma3 = new MaltAddition(crystal20, 1, true);
        MaltAddition ma4 = new MaltAddition(vienna, 0.5f, true);

        List<MaltAddition> malts = new ArrayList<MaltAddition>();
        malts.add(ma1);
        malts.add(ma2);
        malts.add(ma3);
        malts.add(ma4);

        r.maltList = malts;

        return r;
    }

    public static Recipe getLocomotiveKolsch() {
        Recipe r = new Recipe();

        r.name = "Locomotive Kolsch";
        r.batchSize = 5.0f;
        r.originalGravity = 1.045f;
        r.boilGravity = 1.035f;
        r.finalGravity = 1.009f;

        Hop p = new Hop();
        p.setName("Perle");
        p.setAlpha(0.07f);

        Hop s = new Hop();
        s.setName("Saaz");
        s.setAlpha(0.045f);

        HopAddition h60 = new HopAddition(p, 60, 1);
        HopAddition h5 = new HopAddition(s, 5, 1);

        List<HopAddition> hops = new ArrayList<HopAddition>();
        hops.add(h60);
        hops.add(h5);

        r.hopAdditionList = hops;

        Malt twoRow = new Malt("Pale (2-row)", "US", "Grain", 2, true, 1.036f, 1);
        Malt carapils = new Malt("Carapils/Dextrine", "US", "Grain", 2, false, 1.033f, 0.2f);

        MaltAddition ma1 = new MaltAddition(twoRow, 8, true);
        MaltAddition ma2 = new MaltAddition(carapils, 1, true);

        List<MaltAddition> malts = new ArrayList<MaltAddition>();
        malts.add(ma1);
        malts.add(ma2);

        r.maltList = malts;

        return r;
    }

    public static Recipe getGordonLightfootPorter() {
        Recipe r = new Recipe();

        r.name = "Gordon Lightfoot Porter";
        r.batchSize = 5.0f;
        r.originalGravity = 1.062f;
        r.boilGravity = 1.052f;
        r.finalGravity = 1.017f;

        Hop n = new Hop();
        n.setName("Northern Brewer");
        n.setAlpha(0.085f);

        Hop s = new Hop();
        s.setName("Willamette");
        s.setAlpha(0.055f);

        HopAddition h60 = new HopAddition(n, 60, 1);
        HopAddition h5 = new HopAddition(s, 20, 1);

        List<HopAddition> hops = new ArrayList<HopAddition>();
        hops.add(h60);
        hops.add(h5);

        r.hopAdditionList = hops;

        Malt twoRow = new Malt("Pale (2-row)", "US", "Grain", 2, true, 1.036f, 1);
        Malt crystal80 = new Malt("Crystal 80", "US", "Grain", 80, false, 1.034f, 0.2f);
        Malt chocolate = new Malt("Chocolate", "US", "Grain", 350, false, 1.028f, 0.1f);
        Malt roasted = new Malt("Roasted Barley", "US", "Grain", 300, false, 1.025f, 0.1f);

        MaltAddition ma1 = new MaltAddition(twoRow, 10, true);
        MaltAddition ma2 = new MaltAddition(crystal80, 1, true);
        MaltAddition ma3 = new MaltAddition(chocolate, 1, true);
        MaltAddition ma4 = new MaltAddition(roasted, 0.25f, true);

        List<MaltAddition> malts = new ArrayList<MaltAddition>();
        malts.add(ma1);
        malts.add(ma2);
        malts.add(ma3);
        malts.add(ma4);

        r.maltList = malts;

        return r;
    }
}
