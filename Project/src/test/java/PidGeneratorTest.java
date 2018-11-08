import org.junit.Test;
import static org.junit.Assert.*;
import util.*;

public class PidGeneratorTest {

    private static final double MIN_PID = 0d;
    private static final double MAX_PID = 99999999d;

    @Test
    public void testPaymentInfoModelCreation() {
        double testDouble = PidGenerator.generate();
        assertTrue(testDouble >= MIN_PID && testDouble <= MAX_PID);
    }
}