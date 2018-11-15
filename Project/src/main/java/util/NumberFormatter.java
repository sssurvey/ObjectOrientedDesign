package util;

public class NumberFormatter {
    public static String formatToTenDigitStringPid(long number) {
        return String.format("%010d", number);
    }

    public static String formatToSixDigitStringNid(long number) {
        return String.format("%06d", number);
    }
}