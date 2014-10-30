package regex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSearch {

  public static Collection<String> search(String regex, final Collection<String> data) {
    final Pattern pattern = Pattern.compile(regex);
    return new ArrayList<String>() {{
        for (String line : data) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches())
                add(line);
        }
    }};
  }

}
