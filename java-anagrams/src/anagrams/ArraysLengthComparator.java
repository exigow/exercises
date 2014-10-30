package anagrams;

import java.util.Comparator;

public class ArraysLengthComparator<T> implements Comparator<T[]> {

  @Override
  public int compare(T[] o1, T[] o2) {
    return o2.length - o1.length;
  }

}
