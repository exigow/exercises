package main.testing;

import java.util.Date;

public class Worker extends Person implements Workable {

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
