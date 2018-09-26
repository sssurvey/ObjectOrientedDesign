import java.util.StringTokenizer;

public class ImporvedStringTokenizer extends StringTokenizer {

    private String userInput;

    public ImporvedStringTokenizer(String str, String delim, boolean returnDelims) {
        super(str, delim, returnDelims);
        userInput = str;
    }

    public ImporvedStringTokenizer(String str, String delim) {
        super(str, delim);
        userInput = str;
    }

    public ImporvedStringTokenizer(String str) {
        super(str);
        userInput = str;
    }

    public String[] toArray() {
        return userInput.split(" ");
    }
}
