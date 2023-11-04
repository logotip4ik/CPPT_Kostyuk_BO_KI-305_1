import java.io.*;
import java.util.*;

public class Lab2Kostyuk305 {
	public static void main(String[] args) throws FileNotFoundException {
		int nRows;
		char[][] arr;
		String filler;
		
		Scanner in = new Scanner(System.in);
		File dataFile = new File("MyFile.txt");
		PrintWriter fout = new PrintWriter(dataFile);
		
		System.out.print("Введіть розмір квадратної матриці: ");
		
		nRows = in.nextInt();
		in.nextLine();

		System.out.print("\nВведіть символ-заповнювач: ");
		
		filler = in.nextLine();

		if (filler.length() != 1) {
			System.out.print("\nНе коректний символ заповнювач");
			
			fout.flush();
			fout.close();

			return;
		}
		
		int correctNRows = (int) Math.floor(nRows / 2); 
		arr = new char[correctNRows][];
		
		for(int i = 0; i < correctNRows; i++) {
			arr[i]= new char[nRows];
		}

		char normalizedFiller = (char) filler.codePointAt(0);
				
		for(int i = 0; i < correctNRows; i++) {
			System.out.print("\n");
			fout.print("\n");
			
			for(int j = 0; j < arr[i].length; j++) {
					arr[i][j] = normalizedFiller;
					System.out.print(arr[i][j] + " ");
					fout.print(arr[i][j] + " ");
			}

			System.out.print("\n");
			fout.print("\n");
		}
		
		fout.flush();
		fout.close();
	}
}
