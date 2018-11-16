package util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class IdGenerator {
    // should be called only in the BL of the park, this class should have nothing
    // to do with the models

    private static final long MIN_PID = 0l;
    private static final long MAX_PID = 999l;

    private static final long MIN_NID = 0l;
    private static final long MAX_NID = 9999l;

    private static final long MIN_VID = 0l;
    private static final long MAX_VID = 99999999l;

    // TODO: maybe externalize it to a text file
    private static List<Long> generatedPidList = new ArrayList<>();
    private static List<Long> generatedNidList = new ArrayList<>();
    private static List<Long> generatedVidList = new ArrayList<>();

    private IdGenerator() {
    }

    public static long generatePid() {
        long pid = ThreadLocalRandom.current().nextLong(MIN_PID, MAX_PID + 1l);
        while (generatedPidList.contains(pid)) {
            // TODO: need better implementation...
            pid = ThreadLocalRandom.current().nextLong(MIN_PID, MAX_PID + 1l);
        }
        return pid; // permitive.
    }

    public static long generateNid() {
        long nid = ThreadLocalRandom.current().nextLong(MIN_NID, MAX_NID + 1l);
        while (generatedNidList.contains(nid)) {
            // TODO: need better implementation...
            nid = ThreadLocalRandom.current().nextLong(MIN_NID, MAX_NID + 1l);
        }
        return nid; // permitive.
    }

    public static long generateVid() {
        long vid = ThreadLocalRandom.current().nextLong(MIN_VID, MAX_VID + 1l);
        while (generatedVidList.contains(vid)) {
            // TODO: need better implementation...
            vid = ThreadLocalRandom.current().nextLong(MIN_VID, MAX_VID + 1l);
        }
        return vid; // permitive.
    }
}