package com.epam.helloworld.greenhouse;

public class Gardener {
    private int gardener_id;
    private String name;
    private int greenhouse_id;

    public Gardener(int gardener_id, String name, int greenhouse_id) {
        this.gardener_id = gardener_id;
        this.name = name;
        this.greenhouse_id = greenhouse_id;
    }

    public int getId() {
        return gardener_id;
    }

    public void setId(int gardener_id) {
        this.gardener_id = gardener_id;
    }

    public int getGreenhouse() {
        return greenhouse_id;
    }

    public void setGreenhouse(int greenhouse_id) {
        this.greenhouse_id = greenhouse_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
