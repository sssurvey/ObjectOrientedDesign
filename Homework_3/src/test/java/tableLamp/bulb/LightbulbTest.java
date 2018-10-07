package tableLamp.bulb;

import org.junit.Test;
import tableLamp.enumsUtil.Status;

import static org.junit.Assert.*;

public class LightbulbTest {

    @Test
    public void getStatus() {
        Lightbulb lb = new Lightbulb();
        assertEquals(Status.OFF, lb.getStatus());
    }

    @Test
    public void changeStatus() {
        Lightbulb lb = new Lightbulb();
        lb.ChangeStatus(Status.ON);
        assertEquals(Status.ON, lb.getStatus());
    }
}