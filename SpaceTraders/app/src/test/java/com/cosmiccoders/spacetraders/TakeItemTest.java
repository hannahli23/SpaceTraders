package com.cosmiccoders.spacetraders;

import com.cosmiccoders.spacetraders.entity.CargoHold;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

/**
 * Local unit test that tests the takeItem method from the CargoHold class
 * @author kcorrell6
 */
public class TakeItemTest {

    Map<String, Integer> inven = new HashMap<String, Integer>() {
        {
            put("Firearms", 8);
        }
    };

    /**
     * checks when the amount entered to take is less than
     * the amount of the good that is present
     */
    @Test
    public void amountLess() {
        CargoHold test1 = new CargoHold(20);
        test1.setInventory(inven);
        test1.setCurrSize(8);
        test1.takeItem("Firearms", 6);
        Assert.assertEquals(2.0, test1.getNumOfItem("Firearms"), 0.0);
        Assert.assertEquals(2.0, test1.getCurrSize(), 0.0);
    }

    /**
     * checks when amount entered equals the amount
     * of the good that is present
     */
    @Test
    public void amountEqual() {
        CargoHold test1 = new CargoHold(20);
        test1.setInventory(inven);
        test1.setCurrSize(8);
        test1.takeItem("Firearms", 8);
        Assert.assertFalse(test1.getInventory().containsKey("Firearms"));
        Assert.assertEquals(0.0, test1.getCurrSize(), 0.0);
    }

    /**
     * checks when amount entered is greater than
     * the amount of the good that is present
     */
    @Test
    public void amountGreater() {
        CargoHold test1 = new CargoHold(20);
        test1.setInventory(inven);
        test1.setCurrSize(8);
        test1.takeItem("Firearms", 15);
        Assert.assertFalse(test1.getInventory().containsKey("Firearms"));
        Assert.assertEquals(0.0, test1.getCurrSize(), 0.0);
    }
}
