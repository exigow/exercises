import java.io.UnsupportedEncodingException;

class BytesToUtfProcessor {

  public final static char NULL_CHAR = '\u0000';
  private final static String UTF_8 = "UTF-8";
  private final static int[] MASKS = new int[] {0x80, 0xe0, 0xf0, 0xf8};
  private byte[] utfBuffer = new byte[6];
  private int place = 0;

  public String getString(byte[] bytes) throws UnsupportedEncodingException {
    StringBuilder builder = new StringBuilder();
    char ch;
    for (byte aByte : bytes)
      if ((ch = process(aByte)) != NULL_CHAR)
        builder.append(ch);
    return builder.toString();
  }

  private char getUtfChar(byte[] buffer, int place) throws UnsupportedEncodingException {
    return new String(buffer, 0, place, UTF_8).charAt(0);
  }

  private int getExpectedPlace(byte[] buffer) {
    int num = buffer[0] & 255;
    for (int i = 1; i < MASKS.length; i++)
      if (num < MASKS[i])
        return i;
    return 5; // last place
  }

  private char process(byte nextByte) throws UnsupportedEncodingException {
    utfBuffer[place++] = nextByte;
    if (place == getExpectedPlace(utfBuffer)) {
      char result = getUtfChar(utfBuffer, place);
      place = 0;
      return result;
    }
    return NULL_CHAR;
  }

}
