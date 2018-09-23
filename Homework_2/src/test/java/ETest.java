import org.junit.Test;

import static org.junit.Assert.*;

public class ETest {

    @Test
    public void getInfoAboutClass() {
        assertEquals((new E(new B(), new D())).getInfoAboutClass()
                , new E(new B(), new D()).getInfoAboutClass());
    }

    @Test
    public void returnBinfo() {
        assertEquals((new E(new B(), new D())).returnBinfo()
                , (new E(new B(), new D())).returnBinfo());
    }

    @Test
    public void returnDinfo() {
        assertEquals((new E(new B(), new D())).returnDinfo()
                , (new E(new B(), new D())).returnDinfo());
    }
}