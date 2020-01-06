package org.admin;
import java.util.Scanner;
import org.mysqlcsv.CSVCreation;

public class User {

	public static void main(String[] args) {

		CSVCreation ser = new CSVCreation();
		int choise = 0;
		Scanner x = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("Press 1 to pull MySQL table to CSV file");
			System.out.println();
			choise = x.nextInt();

			switch (choise) {
			case 1: {
				ser.csvDownload();
				break;
			}
			default: {
				System.out.println("Not Applicable");
				break;
			}
			}
		}
	}
}
