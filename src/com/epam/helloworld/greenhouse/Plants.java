package com.epam.helloworld.greenhouse;

public interface Plants {
    String getType();

    String getInfoAboutPlant();

    String getRegion();

    void updateInfoAboutPlant(String info);
}
