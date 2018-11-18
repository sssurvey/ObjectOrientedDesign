package util;

public class NumberFormatter {

    public static String formatToEightDigitStringPid(long number) {
        return String.format("%08d", number);
    }

    public static String formatToFourDigitStringNid(long number) {
        return String.format("%04d", number);
    }

    public static String formatToEightDigitStringVid(long number) {
        return String.format("%010d", number);
    }

    public static String formatToTenDigitStringOid(long number) {
        return String.format("%010d", number);
    }

    public static String formatToFifTeenDigitStringTid(long number) {
        return String.format("%015d", number);
    }

    public static String showLastFourDigit(String card) {
        char[] digits = card.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            
            if (i >= digits.length - 4)
                sb.append(digits[i]);
            else 
                sb.append("X");
        }
        return sb.toString();
    }
}