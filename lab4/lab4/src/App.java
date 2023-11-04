import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        PrintStream out = System.out;

        try {
            out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));
            try {
                try {
                    Equations eq = new Equations();
                    out.print("Enter X: ");
                    fout.print(eq.calculate(in.nextDouble()));
                } finally {
                    // Цей блок виконається за будь-яких обставин
                    in.close();
                    fout.flush();
                }
            } catch (CalcException ex) {
                String msg = ex.getMessage();
                // Блок перехоплює помилки обчислень виразу
                out.print(msg);
                fout.print(msg);
                fout.flush();
            }

            fout.close();
        } catch (FileNotFoundException ex) {
            // Блок перехоплює помилки роботи з файлом навіть якщо вони
            // виникли у блоці finally
            out.print("Exception reason: Perhaps wrong file path");
        }
    }
}
