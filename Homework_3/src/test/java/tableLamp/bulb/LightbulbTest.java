package tableLamp.bulb;

import org.junit.Test;

import static org.junit.Assert.*;

public class LightbulbTest {

    @Test
    public void getStatus() {
        Lightbulb lb = new Lightbulb();
        assertEquals(Lightbulb.LightStatus.OFF, lb.getStatus());
    }

    @Test
    public void changeStatus() {
        Lightbulb lb = new Lightbulb();
        lb.ChangeStatus();
        assertEquals(Lightbulb.LightStatus.ON, lb.getStatus());
    }
}