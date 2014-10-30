import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fractals extends JFrame {

  private final static Dimension WINDOW_SIZE = new Dimension(1024, 640);
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
    float cx = -.70176f, cy = -.3842f;
    for (int ix = 0; ix < width; ix++)
      for (int iy = 0; iy < height; iy++) {
        float
          zx = ((float) ix / width - .5f) * 2f,
          zy = ((float) iy / height - .5f) * 2f;
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
        float val = (float) i / 16f;
        result.setRGB(ix, iy, generateRgb((float) Math.cos(val * Math.PI), (float) Math.sin(val * Math.PI), .5f));
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