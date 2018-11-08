import org.junit.Test;
import static org.junit.Assert.*;
import util.*;

public class PidGeneratorTest {

    private static final long MIN_PID = 0l;
    private static final long MAX_PID = 9999999999l;

    @Test
    public void generateTest() {
        long testLong = PidGenerator.generate();
        assertTrue(testLong >= MIN_PID && testLong <= MAX_PID);
    }
}