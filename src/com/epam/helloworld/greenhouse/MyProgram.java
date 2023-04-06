package com.epam.helloworld.greenhouse;

public class MyProgram {
    public static void main(String[] args) {
        Plants plant1 = new PlantFactory().createPlant("floweringPlant", "African Violet", "Tanzania", "Needs bright indirect light", "Flowering Plant");
        Plants plant2 = new PlantFactory().createPlant("shrub", "Boxwood", "Europe", "Needs well-draining soil", "Shrub");
        Plants plant3 = new PlantFactory().createPlant("housePlant", "Peace Lily", "Central and South America", "Needs moderate watering", "House Plant");
        Plants plant4 = new PlantFactory().createPlant("housePlant", "Pothos", "Solomon Islands", "Needs occasional misting", "House Plant");
        Plants plant5 = new PlantFactory().createPlant("shrub", "Lilac", "Europe", "Needs full sun exposure", "Shrub");
        Plants plant6 = new PlantFactory().createPlant("floweringPlant", "Sunflower", "North America", "Requires well-drained soil", "Flowering Plant");
        Plants plant7 = new PlantFactory().createPlant("housePlant", "Snake Plant", "West Africa", "Requires low light", "House Plant");
        Plants plant8 = new PlantFactory().createPlant("shrub", "Azalea", "Asia", "Prefers acidic soil", "Shrub");


        Greenhouse greenhouse = new Greenhouse();
        greenhouse.buyPlant(plant1);
        greenhouse.buyPlant(plant2);
        greenhouse.buyPlant(plant3);
        greenhouse.buyPlant(plant4);
        greenhouse.buyPlant(plant5);
        greenhouse.buyPlant(plant6);
        greenhouse.buyPlant(plant7);
        greenhouse.buyPlant(plant8);

        greenhouse.displayPlantsByType();
        greenhouse.displayPlantsByRegion();

        greenhouse.updatePlantSpecialNeeds(plant1, "Needs less sunshine");


        System.out.println(plant1.getInfoAboutPlant());

        greenhouse.water();
        greenhouse.changeTemperature();

        greenhouse.removePlant(plant4);
        greenhouse.displayPlantsByType();

        if (plant5 instanceof Shrub) {
            ((Shrub) plant5).cutShort();
            ((Shrub) plant5).changeForm();
        }

        if (plant3 instanceof HousePlant) {
            ((HousePlant) plant3).spray();
            ((HousePlant) plant3).replant();
        }

        if (plant1 instanceof FloweringPlant) {
            ((FloweringPlant) plant1).pollinate();
            ((FloweringPlant) plant1).fertilize();
        }
    }
}


