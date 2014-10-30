package anagrams;

public class Pair implements Comparable<Pair> {

  public String left, right;

  @Override
  public int compareTo(Pair o) {
    return o.left.compareTo(left);
  }

  public String toString() {
    return left + " -> " + right;
  }

}
