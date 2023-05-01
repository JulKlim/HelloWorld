package com.epam.helloworld.greenhouse;

public class Plant {
    private int plant_id;
    private String plant_name;
    private String plant_type;

    public Plant(int plant_id, String plant_name, String plant_type) {
        this.plant_id = plant_id;
        this.plant_name = plant_name;
        this.plant_type = plant_type;
    }

    public int getId() {
        return plant_id;
    }

    public void setId(int plant_id) {
        this.plant_id = plant_id;
    }

    public String getName() {
        return plant_name;
    }

    public void setName(String plant_name) {
        this.plant_name = plant_name;
    }

    public String getType() {
        return plant_type;
    }

    public void setType(String plant_type) {
        this.plant_type = plant_type;
    }
}
