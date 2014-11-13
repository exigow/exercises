public class Record {

  public static Record generate() {
    return new Record() {{
      field[0] = randInt(200);
      field[1] = randInt(200);
      field[2] = randInt(360);
    }};
  }

  private static int randInt(int max) {
    return (int) (Math.random() * max);
  }

  public int[] field = new int[3];

  public String printRecord() {
    return field[0] + " " + field[1] + " " + field[2];
  }

  public static Record parseRecord(String line) {
    final String[] values = line.split(" ");
    return new Record() {{
      field[0] = (Integer.parseInt(values[0]));
      field[1] = (Integer.parseInt(values[1]));
      field[2] = (Integer.parseInt(values[2]));
    }};
  }

  @Override
  public String toString() {
    return
      "caller=" + field[0] + ", receiver=" + field[1] + ", length=" + field[2];
  }

}
