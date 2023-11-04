package lab6;

import lab6.App.Data;

public class Book implements Data {
  private String name;
  private int pages;

  public Book(String name, int pages) {
    this.name = name;
    this.pages = pages;
  }

  public void print() {
    System.out.println("Book " + name + " with " + pages + " pages.");
  }

  public int getIdx() {
    return pages;
  }

  public String getName() {
    return name;
  }

  public String setName(String name) {
    this.name = name;

    return this.name;
  }

  public int getPages() {
    return this.pages;
  }

  public int setPages(int pages) {
    this.pages = pages;

    return this.pages;
  }

  public int compareTo(Data d) {
    Integer idx = this.getIdx();

    return idx.compareTo(d.getIdx());
  }
}
