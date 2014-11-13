package phones.comparator;

import phones.Record;

import java.util.Comparator;

public enum RecordComparator implements Comparator<Record> {
  
  CALLER_COMPARISON {

    public int compare(Record o1, Record o2) {
      return o1.caller - (o2.caller);
    }

  },
  RECEIVER_COMPARISON {

    public int compare(Record o1, Record o2) {
      return o1.receiver - (o2.receiver);
    }

  },
  LENGTH_COMPARISON {

    public int compare(Record o1, Record o2) {
      return o1.receiver - (o2.receiver);
    }

  };

  public static Comparator<Record> ascending(final Comparator<Record> other) {
    return new Comparator<Record>() {

      public int compare(Record o1, Record o2) {
        return other.compare(o1, o2);
      }

    };
  }

  public static Comparator<Record> getComparator(final RecordComparator... comparisons) {
    return new Comparator<Record>() {

      public int compare(Record o1, Record o2) {
        for (RecordComparator option : comparisons) {
          int result = option.compare(o1, o2);
          if (result != 0)
            return result;
        }
        return 0;
      }

    };
  }

}
