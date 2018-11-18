package util;

public class NumberFormatter {

    public static String formatToThreeDigitStringPid(long number) {
        return String.format("%03d", number);
    }

    public static String formatToFourDigitStringNid(long number) {
        return String.format("%04d", number);
    }

    public static String formatToEightDigitStringVid(long number) {
        return String.format("%08d", number);
    }

    public static String formatToTenDigitStringOid(long number) {
        return String.format("%10d", number);
    }
}