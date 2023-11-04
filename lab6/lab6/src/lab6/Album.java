package lab6;

import lab6.App.Data;

public class Album implements Data {
  private String name;
  private int numberOfPhotos;

  public Album(String name, int numberOfPhotos) {
    this.name = name;
    this.numberOfPhotos = numberOfPhotos;
  }

  public String getName() {
    return this.name;
  }

  public String setName(String name) {
    this.name = name;
    return this.name;
  }

  public int getIdx() {
    return this.numberOfPhotos;
  }

  public int getNumber() {
    return this.numberOfPhotos;
  }

  public int setNumber(int number) {
    this.numberOfPhotos = number;
    return this.numberOfPhotos;
  }

  public void print() {
    System.out.print("Album " + this.name + " with " + this.numberOfPhotos + " of photos.");
  }

  public int compareTo(Data d) {
    Integer idx = this.getIdx();

    return idx.compareTo(d.getIdx());
  }
}
