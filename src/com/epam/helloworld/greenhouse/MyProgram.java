package com.epam.helloworld.greenhouse;

public class MyProgram {
    public static void main(String[] args) {

        //Objects of the inner class
        HousePlant.HouseplantCare plant3Care = new HousePlant("Peace Lily", "Central and South America", "Needs moderate watering", "House Plant", null).new HouseplantCare("Water twice a week", true, "Well-draining potting mix");
        HousePlant.HouseplantCare plant4Care = new HousePlant("Pothos", "Solomon Islands", "Needs occasional misting", "House Plant", null).new HouseplantCare("Water every 7-10 days", true, "Well-draining potting mix");
        HousePlant.HouseplantCare plant7Care = new HousePlant("Snake Plant", "West Africa", "Requires low light", "House Plant", null).new HouseplantCare("Water once in 3 days", false, "Well-draining potting mix");

        Plants plant1 = PlantFactory.createPlant("floweringPlant", "African Violet", "Tanzania", "Needs bright indirect light", "Flowering Plant", null);
        Plants plant2 = PlantFactory.createPlant("shrub", "Boxwood", "Europe", "Needs well-draining soil", "Shrub", null);
        Plants plant3 = PlantFactory.createPlant("housePlant", "Peace Lily", "Central and South America", "Needs moderate watering", "House Plant", plant3Care);
        Plants plant4 = PlantFactory.createPlant("housePlant", "Pothos", "Solomon Islands", "Needs occasional misting", "House Plant", plant4Care);
        Plants plant5 = PlantFactory.createPlant("shrub", "Lilac", "Europe", "Needs full sun exposure", "Shrub", null);
        Plants plant6 = PlantFactory.createPlant("floweringPlant", "Sunflower", "North America", "Requires well-drained soil", "Flowering Plant", null);
        Plants plant7 = PlantFactory.createPlant("housePlant", "Snake Plant", "West Africa", "Requires low light", "House Plant", plant7Care);
        Plants plant8 = PlantFactory.createPlant("shrub", "Azalea", "Asia", "Prefers acidic soil", "Shrub", null);

        //Object of the nested class
        Greenhouse.TemperatureController temperatureController = new Greenhouse.TemperatureController(9);

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
        System.out.println(((HousePlant.HouseplantCare) plant3Care).getInfoAboutHousePlant());//Method from the inner class

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
        };
        customPlant.updateInfoAboutPlant("Needs to be in the shadow"); //Methods from anonymous class
        System.out.println(customPlant.getInfoAboutPlant());

    }
}


