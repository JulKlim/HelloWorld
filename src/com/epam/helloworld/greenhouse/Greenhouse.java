package com.epam.helloworld.greenhouse;

public class Greenhouse {
    private int greenhouse_id;
    private String location;
    private int plant_id;

    public Greenhouse(int greenhouse_id, String location, int plant_id) {
        this.greenhouse_id = greenhouse_id;
        this.location = location;
        this.plant_id = plant_id;
    }

    public int getId() {
        return greenhouse_id;
    }

    public void setId(int greenhouse_id) {
        this.greenhouse_id = greenhouse_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPlant() {
        return plant_id;
    }

    public void setPlant(int plant_id) {
        this.plant_id = plant_id;
    }
}
