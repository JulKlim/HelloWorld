package com.epam.helloworld.ioexception;

public class PlantFactory {
    public static Plant createPlant(String name, String nativeRegion, String specialNeeds, String type) {
        return new BasicPlant(name, nativeRegion, specialNeeds, type);
    }
}
