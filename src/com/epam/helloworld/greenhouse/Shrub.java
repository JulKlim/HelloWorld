package com.epam.helloworld.greenhouse;

public class Shrub implements Plants {

    public String shrubType;
    public String name;
    public String nativeRegion;
    public String specialNeeds;

    public Shrub(String name, String nativeRegion, String specialNeeds, String shrubType) {
        this.shrubType = shrubType;
        this.name = name;
        this.nativeRegion = nativeRegion;
        this.specialNeeds = specialNeeds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getInfoAboutPlant() {
        return "Name: " + name + ", Native Region: " + nativeRegion + ", Special Needs: " + specialNeeds + ",Type: " + shrubType;
    }

    @Override
    public void updateInfoAboutPlant(String info) {
        specialNeeds = info;
    }

    @Override
    public String getType() {
        return "Shrub";
    }

    @Override
    public String getRegion() {
        return nativeRegion;
    }

    public void cutShort() {
        System.out.println("The Shrub is cut short");
    }

    public void changeForm() {
        System.out.println("The form is changed");
    }
}
