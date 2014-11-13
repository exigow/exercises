import java.lang.reflect.Field;
import java.util.Comparator;

public class FieldComparator<T> implements Comparator<T> {

  private final Field toCompare;

  public FieldComparator(String fieldName, Class c) throws NoSuchFieldException {
    toCompare = c.getField(fieldName);
  }

  @Override
  @SuppressWarnings("unchecked")
  public int compare(T o1, T o2) {
    Object fieldInstance1, fieldInstance2;
    try {
      fieldInstance1 = toCompare.get(o1);
      fieldInstance2 = toCompare.get(o2);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      return 0;
    }
    Comparable
      fieldClass1 = (Comparable) fieldInstance1,
      fieldClass2 = (Comparable) fieldInstance2;
    return fieldClass1.compareTo(fieldClass2);
  }
}