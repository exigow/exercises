package anagrams;

public class Pair implements Comparable<Pair> {

  public String key, original;

  @Override
  public int compareTo(Pair o) {
    return o.key.compareTo(key);
  }

  public String toString() {
    return key + " -> " + original;
  }

}
