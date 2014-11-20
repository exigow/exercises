package main;

import java.lang.reflect.*;
import java.util.Arrays;

public class ClassAnalyzer {

  public static Product analyze(final Class c) {
    if (c == null)
      return new NullProduct();
    return new Product() {{
      name = c.getName();
      fields = c.getDeclaredFields();
      AccessibleObject.setAccessible(fields, true);
      methods = c.getDeclaredMethods();
      AccessibleObject.setAccessible(methods, true);
      sup = c.getSuperclass();
      constructors = c.getDeclaredConstructors();
      AccessibleObject.setAccessible(constructors, true);
      interfaces = c.getInterfaces();
    }};
  }

  private static class Product {

    public String name;
    public Field[] fields;
    public Method[] methods;
    public Constructor[] constructors;
    public Class sup;
    public Class[] interfaces;

    public String toString() {
      String r = name + "{\n";
      r += "fields=" + Arrays.toString(fields) + ";\n";
      r += "constructors=" + Arrays.toString(constructors) + ";\n";
      r += "methods=" + Arrays.toString(methods) + ";\n";
      r += "interfaces=" + Arrays.toString(interfaces) + ";\n";
      r += "extends=" + ClassAnalyzer.analyze(sup) + "}\n";
      return r;
    }

  }

  private static class NullProduct extends Product {

    public String toString() {
      return null;
    }

  }

}
