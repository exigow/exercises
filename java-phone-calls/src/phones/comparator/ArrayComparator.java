package phones.comparator;

import phones.Record;

import java.util.Comparator;

public class ArrayComparator implements Comparator<int[]> {

  private final int field;

  public ArrayComparator(int field) {
    this.field = field;
  }

  @Override
  public int compare(int[] o1, int[] o2) {
    return o1[field] - o2[field];
  }

  public static Comparator<int[]> ascending(final Comparator<int[]> other) {
    return new Comparator<int[]>() {

      public int compare(int[] o1, int[] o2) {
        return other.compare(o1, o2);
      }

    };
  }

  public static Comparator<int[]> getComparator(final ArrayComparator... comparisons) {
    return new Comparator<int[]>() {

      public int compare(int[] o1, int[] o2) {
        for (ArrayComparator option : comparisons) {
          int result = option.compare(o1, o2);
          if (result != 0)
            return result;
        }
        return 0;
      }

    };
  }

}
