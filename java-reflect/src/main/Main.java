package main;

import main.testing.Worker;

public class Main {

  public static void main(String[] args) {

    System.out.println(ClassAnalyzer.analyze(Worker.class));

  }

}
