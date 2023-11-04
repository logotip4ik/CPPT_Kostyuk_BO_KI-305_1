package lab6;

import java.util.ArrayList;

import lab6.App.Data;

public class Shelf<T extends Data> {
  private ArrayList<T> arr;

  public Shelf() {
    arr = new ArrayList<T>();
  }

  public T findMin() {
    if (arr.isEmpty()) {
      return null;
    }

    T min = arr.get(0);

    for (T t : arr) {
      if (t.compareTo(min) < 0) {
        min = t;
      }
    }

    return min;
  }

  public void add(T data) {
    arr.add(data);
  }

  public void remove(int idx) {
    arr.remove(idx);
  }

  public void remove(T data) {
    arr.remove(data);
  }
}
