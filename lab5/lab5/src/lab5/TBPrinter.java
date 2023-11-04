package lab5;

import java.io.*;
import java.util.Scanner;

public class TBPrinter {
  private String filename;
  private TBMode mode;
  
  public enum TBMode {
    Binary,
    Text,
    Random
  }

  TBPrinter() {}

  TBPrinter(String filename) {
    this.filename = filename;
  }
  TBPrinter(String filename, TBMode mode) {
    this.filename = filename;
    this.mode = mode;
  }

  public void writeRes(double res, TBMode type) throws FileNotFoundException, IOException {
    switch (type) {
      case Binary:
        DataOutputStream stream = new DataOutputStream(new FileOutputStream(filename));
        stream.writeDouble(res);
        stream.close();
        break;

      case Text:
        PrintWriter file = new PrintWriter(filename);
        file.printf("%f", res);
        file.close();
        break;
      
      case Random:
        break;
        
      default:
        throw new FileNotFoundException();
    }
  }

  public double readRes(TBMode type) throws FileNotFoundException, IOException {
    double result;

    switch (type) {
      case Binary:
        DataInputStream stream = new DataInputStream(new FileInputStream(filename));
        result = stream.readDouble();
        stream.close();
        break;

      case Text:
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        result = scanner.nextDouble();
        break;

      case Random:
        RandomAccessFile raf = new RandomAccessFile(filename, "r");
        raf.seek(0);
        byte[] bytes = new byte[8];
        raf.read(bytes);
        raf.close();
        result = new Double(new String(bytes));
        break;

        
      default:
        throw new FileNotFoundException();
    }

    return result;
  }

  public void writeRes(String filename, TBMode mode, double res) throws FileNotFoundException, IOException {
    String t = this.filename;

    this.filename = filename;
    this.writeRes(res, mode);
    this.filename = t;
  }

  public void writeRes(double res) throws FileNotFoundException, IOException {
    this.writeRes(res, this.mode);
  }

  public double readRes(String filename, TBMode mode) throws FileNotFoundException, IOException {
    String t = this.filename;

    this.filename = filename;
    double res = this.readRes(mode);
    this.filename = t;

    return res;
  }

  public double readRes() throws FileNotFoundException, IOException {
    return this.readRes(this.mode);
  }
}
