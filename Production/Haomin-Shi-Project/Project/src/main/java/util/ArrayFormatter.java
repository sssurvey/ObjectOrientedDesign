package util;

import java.util.List;

public class ArrayFormatter {
    public static int[] toIntArray(List<Integer> intList) {
		return intList.stream().mapToInt(Integer::intValue).toArray();
	}
}