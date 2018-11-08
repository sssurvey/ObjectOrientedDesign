package util;

public class NumberFormatter {
    public static String formatToTenDigitString(long number) {
        String numberAsString = String.format("%010d", number);
        return numberAsString;
    }
}