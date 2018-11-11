import org.junit.Test;
import static org.junit.Assert.*;
import util.NumberFormatter;

public class NumberFormatterTest {

    @Test
    public void testFormatter() {
        assertEquals("P0000000099", NumberFormatter.formatToTenDigitStringPid(99l));
    }
}