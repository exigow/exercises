package testing;

import testing.cmds.Product;

import java.io.*;

public class Executor {

  public static Product execute(final Process process) throws InterruptedException {
    final long executionTime = waitForAndGetTime(process);
    return new Product() {{
      time = executionTime;
      output = getOutput(process);
      exit = process.exitValue();
    }};
  }

  public static Product executeWithStream(final Process process, InputStream stream) throws InterruptedException {
    flushFromInputToOutput(stream, process.getOutputStream());
    return execute(process);
  }

  private static String getOutput(Process process) {
    StringBuilder output = new StringBuilder();
    Reader streamReader = new InputStreamReader(process.getInputStream());
    BufferedReader reader = new BufferedReader(streamReader);
    String row;
    try {
      while ((row = reader.readLine()) != null)
        output.append(row);
    } catch (Exception e) {
      e.printStackTrace();
    }
    String result = output.toString().trim();
    if (result.isEmpty())
      return null;
    return output.toString();
  }

  private static long waitForAndGetTime(Process process) throws InterruptedException {
    long time = System.nanoTime();
    process.waitFor();
    return System.nanoTime() - time;
  }

  private static void flushFromInputToOutput(final InputStream inputStream, final OutputStream out) {
    try {
      int d;
      while ((d = inputStream.read()) != -1)
        out.write(d);
      out.close();
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
