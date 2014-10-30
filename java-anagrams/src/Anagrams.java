import com.sun.istack.internal.NotNull;

import java.util.*;

public class Anagrams {

  public void build(final Collection<String> source) {
    List<Pair> pairs = buildPairs(source);
    String prev = pairs.get(0).left;
    Collection<String> asd = new ArrayList<String>();
    for (Pair pair : pairs) {
      if (!prev.equals(pair.left))
        asd.clear();
      prev = pair.left;
      asd.add(pair.right);
      System.out.println(asd);
    }
  }

  private List<Pair> buildPairs(final Collection<String> source) {
    List<Pair> pairs =  new ArrayList<Pair>() {{
      for (final String str : source)
        add(new Pair() {{
          left = sortWord(str);
          right = str;
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

  private static class Pair implements Comparable<Pair> {

    public String left, right;

    @Override
    public int compareTo(@NotNull Pair o) {
      return o.left.compareTo(left);
    }

    public String toString() {
      return left + " -> " + right;
    }

  }

}
