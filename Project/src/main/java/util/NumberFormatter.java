package util;

public class NumberFormatter {
    public static String formatToTenDigitStringPid(long number) {
        return String.format("%010d", number);
    }
}