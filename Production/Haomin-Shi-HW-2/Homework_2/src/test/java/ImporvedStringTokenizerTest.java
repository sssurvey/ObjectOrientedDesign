import org.junit.Test;

import static org.junit.Assert.*;

public class ImporvedStringTokenizerTest {

    String[] testStr = new String[]
            {"This is basic", "  Spaced out", "    ", "Ni    Hao", "Spaceed     "};

    @Test
    public void toArray0() {
        for (String s : testStr) {
            ImporvedStringTokenizer ist = new ImporvedStringTokenizer(s);
            assertArrayEquals(s.split(" "), ist.toArray());
        }
    }
}