import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Fractals extends JFrame {

  private BufferedImage image;

  public Fractals() {
    super("fractals");
    setSize(256, 256);
    setResizable(false);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    image = generate(getWidth(), getHeight());
  }

  private BufferedImage generate(int width, int height) {
    BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Color color = new Color(255, 255, 255);
    for (int i = 0; i < width; i++)
      for (int j = 0; j < height; j++)
        result.setRGB(i, j, color.getRGB());
    return result;
  }

  @Override
  public void paint(Graphics graphics) {
    graphics.drawImage(image, 0, 0, this);
  }

}