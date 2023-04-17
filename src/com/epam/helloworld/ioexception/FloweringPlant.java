package com.epam.helloworld.ioexception;

public class FloweringPlant implements Plant {
    public String flowerType;
    public String name;
    public String nativeRegion;
    public String specialNeeds;

    public FloweringPlant(String name, String nativeRegion, String specialNeeds, String flowerType) {
        this.flowerType = flowerType;
        this.name = name;
        this.nativeRegion = nativeRegion;
        this.specialNeeds = specialNeeds;
    }

    @Override
    public String getInfoAboutPlant() {
        return "Name: " + name + ", Native Region: " + nativeRegion + ", Special Needs: " + specialNeeds + ",Type: " + flowerType;
    }

    @Override
    public String getType() {

        return "FloweringPlant";
    }

    @Override
    public String getRegion() {

        return nativeRegion;
    }
    @Override
    public String getName(){

        return name;
    }
    @Override
    public String getSpecialNeeds() {
        return specialNeeds;
    }
}
