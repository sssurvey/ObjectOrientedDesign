import org.junit.Test;

import static org.junit.Assert.*;

public class ImprovedRandomTest {

    @Test
    public void randIntInRange0() {
        int testInt = new ImprovedRandom().randIntInRange(0, 15);
        assertTrue(0 <= testInt && 15 >= testInt);
    }

    @Test
    public void randIntInRange1() {
        int testInt = new ImprovedRandom().randIntInRange(-1, 5);
        assertTrue(-1 <= testInt && 5 >= testInt);
    }

    @Test
    public void randIntInRange2() {
        int testInt = new ImprovedRandom().randIntInRange(0, 3);
        assertTrue(0 <= testInt && 3 >= testInt);
    }

    @Test
    public void randIntInRange3() {
        int testInt = new ImprovedRandom().randIntInRange(0, 0);
        assertTrue(0 <= testInt && 0 >= testInt);
    }

    @Test
    public void ImprovedRandom() {
        ImprovedRandom test = new ImprovedRandom(1231312);
        System.out.println(test.nextInt());
    }
}