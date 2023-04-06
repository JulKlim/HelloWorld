package com.epam.helloworld.greenhouse;

public class FloweringPlant implements Plants {
    public String flowerType;
    public String name;
    public String nativeRegion;
    public String specialNeeds;

    public FloweringPlant(String name, String nativeRegion, String specialNeeds, String flowerType){
        this.flowerType = flowerType;
        this.name = name;
        this.nativeRegion = nativeRegion;
        this.specialNeeds = specialNeeds;
    }
    public String getFlowerTypeType (){
        return flowerType;
    }

    public void setType (String name){
        this.flowerType=flowerType;
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
        return "Name: " + name + ", Native Region: " + nativeRegion + ", Special Needs: " + specialNeeds + ",Type: " + flowerType;
    }
    @Override
    public void updateInfoAboutPlant(String info) {
        specialNeeds = info;
    }
    @Override
    public String getType() {
        return "FloweringPlant";
    }
    @Override
    public String getRegion(){
        return nativeRegion;
    }
    public void pollinate(){
        System.out.println("The Flowering plant is pollinated");
    }
    public void fertilize(){
        System.out.println("The Flowering plant is fertilized");
    }
}
