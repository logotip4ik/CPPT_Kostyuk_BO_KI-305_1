package lab6;

import lab6.App.Data;

public class MyClass implements MyInterface {
  /*
   * / public void print_data(Data data1, Data data2) {
   * System.out.println(data1 + " " + data2);
   * }
   */
 MyClass(){}
  /*public void print_data(T1 data1, T2 data2) {
    System.out.println(data1 + " " + data2);
  }*/

  // public void print_data(Object data1, Object data2) {
  // }
  
  public void print_data(Integer data1, Integer data2) {
    System.out.println(data1 + " " + data2);
  }

  public void print_data(String data1, String data2) {
    System.out.println(data1 + " " + data2);
  }
}
