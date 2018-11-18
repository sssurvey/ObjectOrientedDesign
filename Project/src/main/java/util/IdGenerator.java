package util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import model.visitorModel.VisitorModel;
import storage.StorageEntity;

public class IdGenerator {
    // should be called only in the BL of the park, this class should have nothing
    // to do with the models

    private static final long MIN_PID = 0l;
    private static final long MAX_PID = 99999999l;

    private static final long MIN_NID = 0l;
    private static final long MAX_NID = 9999l;

    private static final long MIN_VID = 0l;
    private static final long MAX_VID = 99999999l;

    private static final long MIN_OID = 0l;
    private static final long MAX_OID = 9999999999l;

    private static final long MIN_TID = 0l;
    private static final long MAX_TID = 999999999999999l;

    // TODO: maybe externalize it to a text file
    private static List<Long> generatedPidList = new ArrayList<>();
    private static List<Long> generatedNidList = new ArrayList<>();
    private static List<Long> generatedVidList = new ArrayList<>();
    private static List<Long> generatedOidList = new ArrayList<>();
    private static List<Long> generatedTidList = new ArrayList<>();

    public static long generatePid() {
        long pid = ThreadLocalRandom.current().nextLong(MIN_PID, MAX_PID + 1l);
        while (generatedPidList.contains(pid)) {
            // TODO: need better implementation...
            pid = ThreadLocalRandom.current().nextLong(MIN_PID, MAX_PID + 1l);
        }
        generatedOidList.add(pid);
        return pid; // permitive.
    }

    public static long generateNid() {
        long nid = ThreadLocalRandom.current().nextLong(MIN_NID, MAX_NID + 1l);
        while (generatedNidList.contains(nid)) {
            nid = ThreadLocalRandom.current().nextLong(MIN_NID, MAX_NID + 1l);
        }
        generatedOidList.add(nid);
        return nid; // permitive.
    }

    public static long generateVid() {
        long vid = ThreadLocalRandom.current().nextLong(MIN_VID, MAX_VID + 1l);
        while (generatedVidList.contains(vid)) {
            vid = ThreadLocalRandom.current().nextLong(MIN_VID, MAX_VID + 1l);
        }
        return vid; // permitive.
    }

    public static long generateOid() {
        long oid = ThreadLocalRandom.current().nextLong(MIN_OID, MAX_OID + 1l);
        while (generatedOidList.contains(oid)) {
            oid = ThreadLocalRandom.current().nextLong(MIN_OID, MAX_OID + 1l);
        }
        generatedOidList.add(oid);
        return oid; // permitive.
    }

    public static long generateTid() {
        long tid = ThreadLocalRandom.current().nextLong(MIN_TID, MAX_TID + 1l);
        while (generatedTidList.contains(tid)) {
            tid = ThreadLocalRandom.current().nextLong(MIN_TID, MAX_TID + 1l);
        }
        generatedOidList.add(tid);
        return tid; // permitive.
    }

    public static String generateVidBasdOnEmail(String email) {
        String vid;
        if (StorageEntity.ALL_VISITORS.isEmpty()) {
            vid = NumberFormatter.formatToFiveDigitStringVid(generateVid());
        } else {
            for (VisitorModel visitorModel : StorageEntity.ALL_VISITORS) {
                if (email.equals(visitorModel.getEmail()))
                    return visitorModel.getVid();
            }
            vid = NumberFormatter.formatToFiveDigitStringVid(generateVid());
        }
        return vid;
    }
}