import org.junit.Test;
import static org.junit.Assert.*;
import util.NumberFormatter;

public class NumberFormatterTest {

    @Test
    public void testFormatter() {
        assertEquals("00000099", NumberFormatter.formatToEightDigitStringPid(99l));
    }
}