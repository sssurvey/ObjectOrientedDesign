import org.junit.Test;

import static org.junit.Assert.*;

public class DTest {

    @Test
    public void setEditable() {
        D dTestable = new D();
        String setString = "zzz";
        dTestable.setEditable(setString);
        assertEquals(setString, dTestable.getEditable());
    }

    @Test
    public void getEditable() {
        D dTestable = new D();
        String setString = "zzz";
        dTestable.setEditable(setString);
        assertEquals(setString, dTestable.getEditable());
    }

    @Test
    public void getInfoAboutClass() {
        D dTestable = new D();
        D dValidator = new D();
        assertEquals(dValidator.getInfoAboutClass(), dTestable.getInfoAboutClass());
    }
}