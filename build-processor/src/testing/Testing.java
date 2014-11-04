package testing;
import testing.cmds.shell.Compile;
import testing.cmds.Product;
import testing.cmds.shell.Remove;
import testing.cmds.shell.Run;

import java.io.FileInputStream;
import java.io.IOException;

public class Testing {

  private final static String TEMP_COMPILED = "_temp";

  public static void main(String[] args) throws IOException, InterruptedException {
    Process compiler = new Compile("main.c", TEMP_COMPILED).exec();
    Product product = Executor.execute(compiler);
    System.out.println("[compilation]\n" + product.toString());

    Process instance = new Run(TEMP_COMPILED).exec();
    Product test = Executor.executeWithStream(instance, new FileInputStream("./cpp/code/train/binary.in"));
    System.out.println("[testing]\n" + test.toString());

    Process remover = new Remove(TEMP_COMPILED).exec();
    Product rem = Executor.execute(remover);
    System.out.println("[removing]\n" + rem.toString());
  }

}
