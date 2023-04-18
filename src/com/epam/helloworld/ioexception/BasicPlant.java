package com.epam.helloworld.ioexception;

public class BasicPlant implements Plant {
    public String type;
    public String name;
    public String nativeRegion;
    public String specialNeeds;

    public BasicPlant(String name, String nativeRegion, String specialNeeds, String type) {
        this.type = type;
        this.name = name;
        this.nativeRegion = nativeRegion;
        this.specialNeeds = specialNeeds;
    }

    @Override
    public String getInfoAboutPlant() {
        return "Name: " + name + ", Native Region: " + nativeRegion + ", Special Needs: " + specialNeeds + ",Type: " + type;
    }

    @Override
    public String getType() {

        return type;
    }

    @Override
    public String getRegion() {

        return nativeRegion;
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public String getSpecialNeeds() {
        return specialNeeds;
    }
}
