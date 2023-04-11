package com.epam.helloworld.greenhouse;

public interface Plants {
    String getType();

    String getInfoAboutPlant();

    String getRegion();

    public void updateInfoAboutPlant(String info);

    void specifyCare(String wateringInstructions, boolean needsFertilizer, String soilType);

    String getCareInfo();
}
