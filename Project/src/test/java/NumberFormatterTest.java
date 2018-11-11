import org.junit.Test;
import static org.junit.Assert.*;
import util.NumberFormatter;

public class NumberFormatterTest {

    @Test
    public void testFormatter() {
        assertEquals("0000000099", NumberFormatter.formatToTenDigitStringPid(99l));
    }
}