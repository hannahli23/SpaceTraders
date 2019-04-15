package com.cosmiccoders.spacetraders;

        import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
        import com.cosmiccoders.spacetraders.entity.Player;
        import com.cosmiccoders.spacetraders.entity.Ships.Gnat;
        import com.cosmiccoders.spacetraders.entity.CargoHold;
        import com.cosmiccoders.spacetraders.entity.Planets.Andromeda;
        import com.cosmiccoders.spacetraders.entity.Market;

        import org.junit.Assert;
        import org.junit.Test;

        import java.util.HashMap;
        import java.util.Map;

/**
 * Local unit test that tests the putItem method from the CargoHold class
 * @author molly williams
 */
public class PutItemCheckTest {

    Map<String, Integer> invent = new HashMap<String, Integer>() {
        {
            put("Water", 3);
            put("Furs", 5);
        }
    };


    /**
     * checks putting the item if it is already in the inventory
     */
    @Test
    public void itemInInventory() {
        CargoHold test1 = new CargoHold(30);
        test1.setInventory(invent);
        test1.putItem("Water", 4);
        Assert.assertEquals(7.0, test1.getInventory().get("Water"), 0.0);
    }

    /**
     * checks putting the item if it is not in inventory
     */
    @Test
    public void itemNotInInventory() {
        CargoHold test1 = new CargoHold(30);
        test1.setInventory(invent);
        test1.putItem("Narcotics", 6);
        Assert.assertEquals(3.0, test1.getInventory().get("Water"), 0.0);
        Assert.assertEquals(6.0, test1.getInventory().get("Narcotics"), 0.0);
    }


    /**
     * checks to see if the currSize is updated correctly
     */
    @Test
    public void sizeIncrement() {
        CargoHold test1 = new CargoHold(30);
        test1.setInventory(invent);
        test1.putItem("Narcotics", 6);
        Assert.assertEquals(14.0, test1.getCurrSize(), 0.0);
    }


}