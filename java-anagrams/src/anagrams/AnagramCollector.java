package anagrams;

import java.util.*;

public class AnagramCollector {

  public static List<String[]> build(final Collection<String> source) {
    Collection<String[]> anagrams = new ArrayList<String[]>();
    List<Pair> pairs = buildPairs(source);
    String prev = pairs.get(0).key;
    Collection<String> temp = new ArrayList<String>();
    for (Pair pair : pairs) {
      if (!prev.equals(pair.key)) {
        anagrams.add(temp.toArray(new String[temp.size()]));
        temp.clear();
      }
      prev = pair.key;
      temp.add(pair.original);
    }
    return (List<String[]>) anagrams;
  }

  private static List<Pair> buildPairs(final Collection<String> source) {
    List<Pair> pairs =  new ArrayList<Pair>() {{
      for (final String str : source)
        add(new Pair() {{
          key = sortWord(str);
          original = str;
        }});
    }};
    Collections.sort(pairs);
    return pairs;
  }

  private static String sortWord(String source) {
    char[] chars = source.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

}
