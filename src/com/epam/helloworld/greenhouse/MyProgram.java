package com.epam.helloworld.greenhouse;

public class MyProgram {
    public static void main(String[] args) {

        //Objects of the inner class
        Plants plant1 = PlantFactory.createPlant("floweringPlant", "African Violet", "Tanzania", "Needs bright indirect light", "Flowering Plant", null);
        Plants plant2 = PlantFactory.createPlant("shrub", "Boxwood", "Europe", "Needs well-draining soil", "Shrub", null);
        Plants plant3 = PlantFactory.createPlant("housePlant", "Peace Lily", "Central and South America", "Needs moderate watering", "House Plant", null);
        assert plant3 != null;
        plant3.specifyCare("Water twice a week", true, "Well-draining potting mix");
        Plants plant4 = PlantFactory.createPlant("housePlant", "Pothos", "Solomon Islands", "Needs occasional misting", "House Plant", null);
        assert plant4 != null;
        plant4.specifyCare("Water twice a week", true, "Well-draining potting mix");
        Plants plant5 = PlantFactory.createPlant("shrub", "Lilac", "Europe", "Needs full sun exposure", "Shrub", null);
        Plants plant6 = PlantFactory.createPlant("floweringPlant", "Sunflower", "North America", "Requires well-drained soil", "Flowering Plant", null);
        Plants plant7 = PlantFactory.createPlant("housePlant", "Snake Plant", "West Africa", "Requires low light", "House Plant", null);
        assert plant7 != null;
        plant7.specifyCare("Water twice a week", true, "Well-draining potting mix");
        Plants plant8 = PlantFactory.createPlant("shrub", "Azalea", "Asia", "Prefers acidic soil", "Shrub", null);


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

        assert plant1 != null;
        PlantFactory.updatePlantSpecialNeeds(plant1, "Needs less sunshine");

        System.out.println(plant1.getInfoAboutPlant());
        greenhouse.water();

        greenhouse.removePlant(plant4);
        greenhouse.displayPlantsByType();

        if (plant5 instanceof Shrub) {
            ((Shrub) plant5).cutShort();
            ((Shrub) plant5).changeForm();
            ((Shrub) plant5).setName("Violet Lilac");
            System.out.println(((Shrub) plant5).getName());
        }


        if (plant3 instanceof HousePlant) {
            ((HousePlant) plant3).spray();
            ((HousePlant) plant3).replant();
            ((HousePlant) plant3).setNativeRegion("North and South America");
            System.out.println(((HousePlant) plant3).getNativeRegion());
        }

        if (plant1 instanceof FloweringPlant) {
            ((FloweringPlant) plant1).pollinate();
            ((FloweringPlant) plant1).fertilize();
            ((FloweringPlant) plant1).setName("Tanzanian Violet");
            System.out.println(((FloweringPlant) plant1).getName());
        }

        Greenhouse.TemperatureController.checkTemperature(); //Method from the nested class
        System.out.println(plant3.getCareInfo());//Method from the inner class

        //Anonymous class
        Plants customPlant = new Plants() {
            final String name = "Basil";
            final String nativeRegion = "India";
            public String specialNeeds;
            final String type = "Herb";

            @Override
            public String getType() {
                return type;
            }

            @Override
            public String getInfoAboutPlant() {
                return "Name: " + name + ", Native Region: " + nativeRegion + ", Special needs: " + specialNeeds + ", Type: " + type;
            }

            @Override
            public String getRegion() {
                return nativeRegion;
            }

            @Override
            public void updateInfoAboutPlant(String info) {
                specialNeeds = info;

            }

            @Override
            public void specifyCare(String wateringInstructions, boolean needsFertilizer, String soilType) {
                this.specialNeeds = specialNeeds;
            }

            @Override
            public String getCareInfo() {
                return null;
            }
        };
        customPlant.updateInfoAboutPlant("Needs to be in the shadow"); //Methods from anonymous class
        System.out.println(customPlant.getInfoAboutPlant());

    }
}


