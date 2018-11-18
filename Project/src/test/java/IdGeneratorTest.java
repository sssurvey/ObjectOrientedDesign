import org.junit.Test;
import static org.junit.Assert.*;
import util.*;

public class IdGeneratorTest {

    private static final long MIN_PID = 0l;
    private static final long MAX_PID = 9999999999l;

    private static final long MIN_NID = 0l;
    private static final long MAX_NID = 9999l;

    private static final long MIN_VID = 0l;
    private static final long MAX_VID = 99999999l;

    private static final long MIN_OID = 0l;
    private static final long MAX_OID = 9999999999l;

    private static final long MIN_TID = 0l;
    private static final long MAX_TID = 999999999999999l;

    @Test
    public void generatePidTest() {
        long testLong = IdGenerator.generatePid();
        assertTrue(testLong >= MIN_PID && testLong <= MAX_PID);
    }

    @Test
    public void generateNidTest() {
        long testLong = IdGenerator.generateNid();
        assertTrue(testLong >= MIN_NID && testLong <= MAX_NID);
    }

    @Test
    public void generateVidTest() {
        long testLong = IdGenerator.generateVid();
        assertTrue(testLong >= MIN_VID && testLong <= MAX_VID);
    }

    @Test
    public void generateOidTest() {
        long testLong = IdGenerator.generateOid();
        assertTrue(testLong >= MIN_OID && testLong <= MAX_OID);
    }

    @Test
    public void generateTidTest() {
        long testLong = IdGenerator.generateTid();
        assertTrue(testLong >= MIN_TID && testLong <= MAX_TID);
    }
}