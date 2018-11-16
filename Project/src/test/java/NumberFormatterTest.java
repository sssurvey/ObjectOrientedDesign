import org.junit.Test;
import static org.junit.Assert.*;
import util.NumberFormatter;

public class NumberFormatterTest {

    @Test
    public void testFormatter() {
        assertEquals("099", NumberFormatter.formatToThreeDigitStringPid(99l));
    }
}