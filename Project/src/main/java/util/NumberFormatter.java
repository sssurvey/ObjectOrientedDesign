package util;

public class NumberFormatter {

    public static String formatToThreeDigitStringPid(long number) {
        return String.format("%03d", number);
    }

    public static String formatToFourDigitStringNid(long number) {
        return String.format("%04d", number);
    }

    public static String formatToEightDigitStringNid(long number) {
        return String.format("%08d", number);
    }
}