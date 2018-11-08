package util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PidGenerator {
    // TODO: This class should be a singleton class, and should be called only in
    // the BL of the park, this class should have nothing to do with the models

    private static final double MIN_PID = 0d;
    private static final double MAX_PID = 99999999d;
    // TODO: maybe externalize it to a text file
    private static List<Double> generatedDoubleList = new ArrayList<>();

    private PidGenerator() {
    }

    public static double generate() {
        Double pid = ThreadLocalRandom.current().nextDouble(MIN_PID, MAX_PID + 1);
        while (generatedDoubleList.contains(pid)){
            // TODO: need better implementation...
            pid = ThreadLocalRandom.current().nextDouble(MIN_PID, MAX_PID + 1);
        }
        return pid; // permitive.
    }
}