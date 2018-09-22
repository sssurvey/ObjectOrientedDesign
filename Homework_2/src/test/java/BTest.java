import org.junit.Test;

import static org.junit.Assert.*;

public class BTest {
    
    @Test
    public void getInfoAboutClass() {
        B testable = new B();
        assertEquals(new B().getInfoAboutClass(), testable.getInfoAboutClass());
    }

    @Test
    public void setEditable() {
        String testString = "xxx";
        B testable = new B();
        testable.setEditable(testString);
        assertEquals(testString, testable.getEditable());
    }

    @Test
    public void getEditable() {
        String testString = "xxx";
        B testable = new B();
        testable.setEditable(testString);
        assertEquals(testString, testable.getEditable());
    }
}