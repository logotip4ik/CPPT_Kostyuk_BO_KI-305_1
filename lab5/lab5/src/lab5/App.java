package lab5;

import java.io.*;
import java.util.Scanner;

import lab5.TBPrinter.TBMode;

public class App {
    public static void main(String[] args) throws Exception {
        int x;
        PrintStream out = System.out;

        try {
            Scanner in = new Scanner(System.in);

            TBPrinter printer = new TBPrinter();

            x = (int)printer.readRes("test.txt", TBMode.Random);
            
            Equations eq = new Equations();

            out.print("Read X from file ? (y/n)\n: ");
            if (in.next().equals("y")) {
                out.print("Enter file name: ");
                in.nextLine();
                String fName = in.nextLine();

                out.print("Enter mode\nt - for text\nb - for binary\n: ");
                TBMode mode = in.next().equals("t") ? TBMode.Text : TBMode.Binary;

                x = (int)printer.readRes(fName, mode);
            } else {
                out.print("Enter X: ");
                x = in.nextInt();
            }

            out.println("X is: " + x);

            double res = eq.calculate(x);

            out.print("Enter file name to write: ");
            in.nextLine();
            String fName = in.nextLine();

            out.print("Enter mode\nt - for text\nb - for binary\n: ");
            TBMode mode = in.next().equals("t") ? TBMode.Text : TBMode.Binary;

            printer.writeRes(fName, mode, res);

            in.close();
        } catch (FileNotFoundException ex) {
            out.print(ex.getMessage());
        }
    }
}
