import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Fractals extends JFrame {

  private final static Dimension WINDOW_SIZE = new Dimension(640, 480);
  private BufferedImage generated;

  public Fractals() {
    super("fractals");
    setSize(WINDOW_SIZE);
    setLocationRelativeTo(null);
    setResizable(false);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    generated = generate(getWidth(), getHeight());
  }

  private BufferedImage generate(int width, int height) {
    BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    fill(result, new Color(255, 0, 255));
    float seedX = .5f, seedY = .175f;
    for (int ix = 0; ix < width; ix++)
      for (int iy = 0; iy < height; iy++)
        for (int i = 0; i < 32; i++) {
          float
            x = (float) ix / width,
            y = (float) iy / height;
          result.setRGB(ix, iy, generateRgb(x, y, 0f));
        }
    return result;
  }

  /*
    f <0; 1>
  */
  private int generateRgb(float r, float g, float b) {
    return
      (((int)(r * 255) & 0x0ff) << 16) |
      (((int)(g * 255) & 0x0ff) << 8) |
      ((int)(b * 255) & 0x0ff);
  }

  private static void fill(BufferedImage image, Color color) {
    Graphics2D g2d = image.createGraphics();
    g2d.setColor(color);
    g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
  }

  @Override
  public void paint(Graphics graphics) {
    graphics.drawImage(generated, 0, 0, this);
  }

}