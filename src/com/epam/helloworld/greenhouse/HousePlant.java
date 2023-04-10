package com.epam.helloworld.greenhouse;

public class HousePlant implements Plants {
    public String houseType;
    public String name;
    public String nativeRegion;
    public String specialNeeds;

    public HouseplantCare care;

    public HousePlant(String name, String nativeRegion, String specialNeeds, String houseType, HouseplantCare care) {
        this.houseType = houseType;
        this.name = name;
        this.nativeRegion = nativeRegion;
        this.specialNeeds = specialNeeds;
        this.care = care;
    }


    public String getNativeRegion() {
        return nativeRegion;
    }

    public void setNativeRegion(String nativeRegion) {
        this.nativeRegion = nativeRegion;
    }

    @Override
    public String getInfoAboutPlant() {
        return "Name: " + name + ", Native Region: " + nativeRegion + ", Special Needs: " + specialNeeds + ",Type: " + houseType;
    }

    @Override
    public void updateInfoAboutPlant(String info) {
        specialNeeds = info;

    }

    @Override
    public String getType() {
        return "HousePlant";
    }

    @Override
    public String getRegion() {
        return nativeRegion;
    }

    public void replant() {
        System.out.println("The House plant is moved to the other flower pot");
    }

    public void spray() {
        System.out.println("The House plant is misted");
    }

    //Inner class
    public class HouseplantCare {
        String wateringInstructions;
        boolean needsFertilizer;
        String soilType;

        public HouseplantCare(String wateringInstructions, boolean needsFertilizer, String soilType) {
            this.wateringInstructions = wateringInstructions;
            this.needsFertilizer = needsFertilizer;
            this.soilType = soilType;
        }

        public String getInfoAboutHousePlant() {
            return "Watering instructions: " + wateringInstructions + ",  Is fertilize needed: " + needsFertilizer + ", Soil type: " + soilType;
        }
    }
}
