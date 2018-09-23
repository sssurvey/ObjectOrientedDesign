import org.junit.Test;

import static org.junit.Assert.*;

public class CTest {

    @Test
    public void getInfoAboutClass() {
        C cTestable = new C(new B(), new D());
        C cValidator = new C(new B(), new D());
        assertEquals(cValidator.getInfoAboutClass(), cTestable.getInfoAboutClass());
    }

    @Test
    public void returnBinfo() {
        C cTestable = new C(new B(), new D());
        C cValidator = new C(new B(), new D());
        assertEquals(cValidator.returnBinfo(), cTestable.returnBinfo());
    }

    @Test
    public void returnDinfo() {
        C cTestable = new C(new B(), new D());
        C cValidator = new C(new B(), new D());
        assertEquals(cValidator.returnDinfo(), cTestable.returnDinfo());
    }
}