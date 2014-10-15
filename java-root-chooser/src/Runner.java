/*
  Zadanie 1.2
  Napisz program, który pyta o katalog (na przykład używając JFileChooser'a)
  a następnie wyświetla pełne nazwy dziesięciu największych plików
  w całym poddrzewie systemu plików którego korzeniem jest wybrany katalog.

  UWAGA: Program nie może zapamiętywać wszystkich napotkanych plików!
  Znalezione pliki są pamiętane w tablicy o wymiarze 10 uaktualnianej na bieżąco
  w trakcie przetwarzania drzewa katalogów. [Aby JFileChooser pozwalał wybrać katalog,
  a nie pojedynczy plik, należy po utworzeniu wywołać
  na jego rzecz metodę setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY)
  i dopiero wtedy wywołać showOpenDialog].
 */

import javax.swing.*;
import javax.swing.SwingUtilities;

public class Runner {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
          System.err.println("Can't set native look and feel.");
          e.printStackTrace();
        }
        new Frame();
      }
    });
  }
}