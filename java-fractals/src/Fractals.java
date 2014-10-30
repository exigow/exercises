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
    Graphics2D graphics2D = result.createGraphics();
    graphics2D.setColor(new Color(255, 128, 64));
    graphics2D.fillRect(0, 0, result.getWidth(), result.getHeight());
    //fill(result, new Color(255, 128, 32));
    /*for (int i = 0; i < width; i++)
      for (int j = 0; j < height; j++)
        result.setRGB(i, j, color.getRGB());*/
    return result;
  }

  @Override
  public void paint(Graphics graphics) {
    graphics.drawImage(generated, 0, 0, this);
  }

}