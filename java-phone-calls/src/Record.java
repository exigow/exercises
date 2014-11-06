public class Record {

  public static Record generate() {
    return new Record() {{
      call = randInt(200);
      rec = randInt(200);
      length = randInt(360);
    }};
  }

  private static int randInt(int max) {
    return (int)(Math.random() * max);
  }

  int call, rec, length;

  public String printRecord() {
    return call + " " + rec + " " + length;
  }

  public static Record loadRecord(String input) {
    final String[] values = input.split(" ");
    return new Record() {{
      call = (Integer.parseInt(values[0]));
      rec = (Integer.parseInt(values[1]));
      length = (Integer.parseInt(values[2]));
    }};
  }

  @Override
  public String toString() {
    return "Record{" +
      "call=" + call +
      ", rec=" + rec +
      ", length=" + length +
      '}';
  }

}
