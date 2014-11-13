package phones;

public class Record {

  public static Record generate() {
    return new Record() {{
      caller = randInt(200);
      receiver = randInt(200);
      length = randInt(360);
    }};
  }

  private static int randInt(int max) {
    return (int) (Math.random() * max);
  }

  public int caller, receiver, length;

  public String printRecord() {
    return caller + " " + receiver + " " + length;
  }

  public static Record parseRecord(String line) {
    final String[] values = line.split(" ");
    return new Record() {{
      caller = (Integer.parseInt(values[0]));
      receiver = (Integer.parseInt(values[1]));
      length = (Integer.parseInt(values[2]));
    }};
  }

  @Override
  public String toString() {
    return
      "caller=" + caller + ", receiver=" + receiver + ", length=" + length;
  }

}
