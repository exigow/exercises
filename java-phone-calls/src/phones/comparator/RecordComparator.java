package phones.comparator;

import phones.Record;

import java.util.Comparator;

public enum RecordComparator implements Comparator<Record> {
  
  CALLER_SORT {
    public int compare(Record o1, Record o2) {
      return o1.field[0] - (o2.field[0]);
    }},
  RECEIVER_SORT {
    public int compare(Record o1, Record o2) {
      return o1.field[1] - (o2.field[1]);
    }};

  public static Comparator<Record> decending(final Comparator<Record> other) {
    return new Comparator<Record>() {
      public int compare(Record o1, Record o2) {
        return -1 * other.compare(o1, o2);
      }
    };
  }

  public static Comparator<Record> getComparator(final RecordComparator... multipleOptions) {
    return new Comparator<Record>() {
      public int compare(Record o1, Record o2) {
        for (RecordComparator option : multipleOptions) {
          int result = option.compare(o1, o2);
          if (result != 0) {
            return result;
          }
        }
        return 0;
      }
    };
  }
}