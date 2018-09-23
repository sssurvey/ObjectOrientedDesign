import org.junit.Test;

import static org.junit.Assert.*;

public class ATest {

    @Test
    public void returnBinfo() {
        B bValidator = new B();
        A aTestable = new A(new B());
        assertEquals(bValidator.getInfoAboutClass(), aTestable.returnBinfo());
    }

    @Test
    public void getInfoAboutClass() {
        B bInject = new B();
        A aValidator = new A(bInject);
        A aTestable = new A(bInject);
        assertEquals(aValidator.getInfoAboutClass(), aTestable.getInfoAboutClass());
    }
}