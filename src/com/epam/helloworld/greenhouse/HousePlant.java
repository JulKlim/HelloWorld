package com.epam.helloworld.greenhouse;

public class HousePlant implements Plants {
    public String houseType;
    public String name;
    public String nativeRegion;
    public String specialNeeds;

    public HousePlant(String name, String nativeRegion, String specialNeeds, String houseType){
        this.houseType = houseType;
        this.name = name;
        this.nativeRegion = nativeRegion;
        this.specialNeeds = specialNeeds;
    }
    public String getHouseTypeType (){
        return houseType;
    }

    public void setType (String name){
        this.houseType=houseType;
    }
    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name=name;
    }
    public String getNativeRegion(){
        return nativeRegion;
    }

    public void setNativeRegion(String nativeRegion){
        this.nativeRegion = nativeRegion;
    }

    public String getSpecialNeeds(){
        return specialNeeds;
    }

    public void setSpecialNeeds(String specialNeeds){
        this.specialNeeds = specialNeeds;
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
    public String getRegion(){
        return nativeRegion;
    }
    public void replant(){
        System.out.println("The House plant is moved to the other flower pot");
    }
    public void spray(){
        System.out.println("The House plant is misted");
    }
}
