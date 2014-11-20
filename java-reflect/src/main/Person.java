package main;

public class Person {

  private int age;
  public String name, lastName;
  protected float value;
  private boolean isDead;

  public Person(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  private void kill() {
    isDead = true;
  }

}
