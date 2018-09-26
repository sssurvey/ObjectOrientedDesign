import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ImprovedRandom extends Random {

    public ImprovedRandom() {
        super();
    }

    public ImprovedRandom(long seed) {
        super(seed);
    }

    public int randIntInRange(int lowBound, int highBound) {
        int rand;
        if (lowBound == highBound) rand = highBound;
        else rand = ThreadLocalRandom.current().nextInt(lowBound, highBound);
        return rand;
    }
}
