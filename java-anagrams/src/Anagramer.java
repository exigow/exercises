import java.util.ArrayList;
import java.util.Collection;

public class Anagramer {
    public static Collection<String> search(final String source, final Collection<String> data) {
        return new ArrayList<String>() {{
            for (String line : data)
                if (Anagram.isAnagram(line, source))
                    add(line);
        }};
    }

}
