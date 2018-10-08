package tableLamp.control;

import org.junit.Test;
import tableLamp.bulb.Lightbulb;
import tableLamp.enumsUtil.Status;

import static org.junit.Assert.*;

public class ButtonTest {

    @Test
    public void getStatus() {
        Button button = new Button(new Lightbulb());
        assertEquals(Status.OFF, button.getStatus());
    }

    @Test
    public void pushButton() {
        Button button = new Button(new Lightbulb());
        button.pushButton();
        assertEquals(Status.ON, button.getStatus());
    }
}