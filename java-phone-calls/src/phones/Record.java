package phones;

public class Record {

  public static Record generate() {
    return new Record() {{
      value[0] = randInt(200);
      value[1] = randInt(200);
      value[2] = randInt(360);
    }};
  }

  private static int randInt(int max) {
    return (int) (Math.random() * max);
  }

  public final int value[] = new int[3];

  public String printRecord() {
    return value[0] + " " + value[1] + " " + value[2];
  }

  public static int[] parseRecord(String line) {
    final String[] values = line.split(" ");
    return new int[] {
      Integer.parseInt(values[0]),
      Integer.parseInt(values[1]),
      Integer.parseInt(values[2])
    };
  }

  @Override
  public String toString() {
    return
      "caller=" + value[0] + ", receiver=" + value[1] + ", length=" + value[2];
  }

}
