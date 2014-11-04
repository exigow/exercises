package testing;
import testing.tests.TestFinder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Testing {

  private final static String TEMP_COMPILED = "_temp";

  public static void main(String[] args) throws IOException, InterruptedException {
    Path root = Paths.get("build-processor/code");
    new TestFinder().find(root);

    /*Process compiler = new Compile("main.c", TEMP_COMPILED).exec();
    Product product = Executor.execute(compiler);
    System.out.println("[compilation]\n" + product.toString());

    Process instance = new Run(TEMP_COMPILED).exec();
    Product test = Executor.executeWithStream(instance, new FileInputStream("./build-processor/code/train/binary.in"));
    System.out.println("[testing]\n" + test.toString());

    Process remover = new Remove(TEMP_COMPILED).exec();
    Product rem = Executor.execute(remover);
    System.out.println("[removing]\n" + rem.toString());*/
  }

}
