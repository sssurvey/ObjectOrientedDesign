package tableLamp.control;

import org.junit.Test;
import tableLamp.enumsUtil.Status;

import static org.junit.Assert.*;

public class ButtonTest {

    @Test
    public void getStatus() {
        Button button = new Button();
        assertEquals(Status.OFF, button.getStatus());
    }

    @Test
    public void flipTheSwitch() {
        Button button = new Button();
        button.flipTheSwitch();
        assertEquals(Status.ON, button.getStatus());
    }
}