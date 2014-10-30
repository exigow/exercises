import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
    float cx = .5f, cy = .5f;
    for (int ix = 0; ix < width; ix++)
      for (int iy = 0; iy < height; iy++) {
        float
          zx = ((float) ix / width - .5f) * 4f,
          zy = ((float) iy / height - .5f) * 4f;
        int i = 0;
        for (; i < 512; i++) {
          float
            x = (zx * zx - zy * zy) + cx,
            y = (zy * zx + zx * zy) + cy;
          if ((zx * zx + zy * zy) > 4.0f)
            break;
          zx = x;
          zy = y;
        }
        result.setRGB(ix, iy, generateRgb((float) i / 16f, 0f, 0f));
      }
    return result;
  }

  private int generateRgb(float r, float g, float b) {
    return
      (((int)(r * 255) & 0x0ff) << 16) |
      (((int)(g * 255) & 0x0ff) << 8) |
      ((int)(b * 255) & 0x0ff);
  }

  @Override
  public void paint(Graphics graphics) {
    graphics.drawImage(generated, 0, 0, this);
  }

}