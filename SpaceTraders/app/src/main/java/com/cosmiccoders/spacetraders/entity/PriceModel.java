package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.TechLevel;
import com.cosmiccoders.spacetraders.model.Interactor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceModel {
    List<String> WaterList = Arrays.asList("0", "0", "2", "30", "3", "4", "DROUGHT",
            "LOTSOFWATER", "DESERT", "30", "50");
    List<String> FursList = Arrays.asList("0", "0", "0", "250", "10", "10", "COLD",
            "RICHFAUNA", "LIFELESS", "230", "280");
    List<String> FoodList = Arrays.asList("1", "0", "1", "100", "5", "5", "CROPFAIL",
            "RICHSOIL", "POORSOIL", "90", "160");
    List<String> OreList = Arrays.asList("2", "2", "3", "350", "20", "10", "WAR",
            "MINERALRICH", "MINERALPOOR", "350", "420");
    List<String> GamesList = Arrays.asList("3", "1", "6", "250", "-10", "5", "BOREDOM",
            "ARTISTIC", "never", "160", "270");
    List<String> FireArmsList = Arrays.asList("3", "1", "5", "1250", "-75", "100", "WAR",
            "WARLIKE", "never", "600", "1100");
    List<String> MedicineList = Arrays.asList("4", "1", "6", "650", "-20", "10", "PLAGUE",
            "LOTSOFHERBS", "never", "400", "700");
    List<String> MachinesList = Arrays.asList("4", "3", "5", "900", "-30", "5", "LACKOFWORKERS",
            "never", "never", "600", "800");
    List<String> NarcoticsList = Arrays.asList("5", "0", "5", "3500", "-125", "150", "BOREDOM",
            "WEIRDMUSHROOMS", "never", "2000", "3000");
    List<String> RobotsList = Arrays.asList("6", "4", "7", "5000", "-150", "100", "LACKOFWORKERS",
            "never", "never", "3500", "5000");
    HashMap<String, List> tradeGoods = new HashMap<String, List>() {
        {
            put("Water", WaterList);
            put("Furs", FursList);
            put("Food", FoodList);
            put("Ore", OreList);
            put("Games", GamesList);
            put("Firearms", FireArmsList);
            put("Medicine", MedicineList);
            put("Machine", MachinesList);
            put("Narcotics", NarcoticsList);
            put("Robots", RobotsList);
        }
    };

    public HashMap<String, Integer> MarketGoods(PlanetResources resource, TechLevel level) {
            HashMap<String, Integer> prices = new HashMap<>();
            for (Map.Entry<String, List> entry: tradeGoods.entrySet()) {
                List<String> firstElement= entry.getValue();
                int minTechP = Integer.parseInt(firstElement.get(0));
                int minTechU = Integer.parseInt(firstElement.get(1));
                int base = Integer.parseInt(firstElement.get(3));
                int pricePerTech = Integer.parseInt(firstElement.get(4));
                int var = Integer.parseInt(firstElement.get(5))/100;
                String radicalUp = firstElement.get(6);
                String cr = firstElement.get(7);

                if(level.getRepresentation() >= minTechP) {
                    if(resource.getRepresentation() == radicalUp) {
                        base *= (1+var);
                    } else if (resource.getRepresentation() == cr) {
                        base *= (1-var);
                    }
                    for(int i = 0; i < level.getRepresentation(); i++) {
                        base *= pricePerTech;
                    }

                    prices.put(entry.getKey(), (Integer) base);
                }
            }
            return prices;
    }


}
