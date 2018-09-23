import org.junit.Test;

import static org.junit.Assert.*;

public class FTest {

    @Test
    public void getInfoAboutClass() {
        assertEquals((new F(new D())).getInfoAboutClass(), (new F(new D())).getInfoAboutClass());
    }

    @Test
    public void instanceCounter() {
        assertEquals(2, (new F(new D()).instanceCounter()));
    }
}