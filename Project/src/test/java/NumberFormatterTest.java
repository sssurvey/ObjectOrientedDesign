import org.junit.Test;
import static org.junit.Assert.*;
import util.NumberFormatter;

public class NumberFormatterTest {

    @Test
    public void testFormatterEight() {
        assertEquals("00000099", NumberFormatter.formatToEightDigitStringPid(99l));
    }

    @Test
    public void testFormatterFour() {
        assertEquals("0099", NumberFormatter.formatToFourDigitStringNid(99l));
    }

    @Test
    public void testFormatterFive() {
        assertEquals("00099", NumberFormatter.formatToFiveDigitStringVid(99l));
    }

    @Test
    public void testFormatterTen() {
        assertEquals("0000000099", NumberFormatter.formatToTenDigitStringOid(99l));
    }

    @Test
    public void testFormatterFifteen() {
        assertEquals("000000000000099", NumberFormatter.formatToFifTeenDigitStringTid(99l));
    }

    @Test
    public void testShowLastFourDigits() {
        assertEquals("XXXXXXXX4234", NumberFormatter.showLastFourDigit("000000004234"));
    }
}