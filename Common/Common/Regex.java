package Common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static String getFirstTextMatched(String text, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        matcher.find();
        return matcher.group();
    }
}
