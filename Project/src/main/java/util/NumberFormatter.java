package util;

public class NumberFormatter {

    private static final String PID_PREFIX = "P";

    public static String formatToTenDigitStringPid(long number) {
        String numberAsString = String.format("%010d", number);
        StringBuilder stringBuilder = new StringBuilder(PID_PREFIX);
        stringBuilder.append(numberAsString);
        return stringBuilder.toString();
    }
}