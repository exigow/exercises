package main;

import java.util.Date;

public class Worker extends Person {

  public Date employed;
  private int salary, money;

  public Worker(int salary) {
    super("bob", "builder");
    this.salary = salary;
  }

  public void work(int howLong) {
    money += howLong * salary;
  }

}
