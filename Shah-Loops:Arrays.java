import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Project 4: Decision Structures, loops, files, arrays
 * @author Shahzada Shah
 * @version 1.0
 */
public class projectFour {
	// If any issue about the file then "IOException" thrown
	public static void main(String[] args) throws IOException {
		// 1,2,3 - Number
		int choice;
		do {
			// Printing Out Statements On Screen
			System.out.println("Welcome to Grade Center! ");
			System.out.println("Enter 1 to generate and display a report. ");
			System.out.println("Enter 2 to generate a report and save it into a file. ");
			System.out.println("Enter 3 to quit. ");
			System.out.print("Enter a choice:  ");
			// Take Input + Picks The User 1,2,3
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			System.out.println();
			// Declaring Array
			// Test one first array store test one scores for "four students"
			// Test one first array store test two scores for "four students"
			// Double = Get average of both tests
			// Char = Letter grade - Get this for-loop in case1
			// FileName = Case2 user to enter for the file name
			int[] testOne = new int[4];
			int[] testTwo = new int[4];
			double[] average = new double[4];
			char[] grade = new char[4];
			String fileName;
			// Switch statement pick choices
			// When we pick 1,2,3, it executes whatever is in it
			// Case1: Printing out statement then taking input from the user
			// For loop:
			// 1st = get scores from user test1,
			// 2nd = get scores from user test2,
			// 3rd = test1 and test2 average
			// 3rd = Get ranging the averages to get Letter grade for ex, if
			// average greater then 90 = A
			// average greater then 80 = B and so on
			// Last part of case1 Display the Test 1 / Test 2 / Average / Grade
			// Print all the statements on the file
			// User type in file name
			// Then file name is saved in String file
			// Taking user name of file
			// Creating file while creating a object/opening file
			// We are using fw write into the text file whatever we printed in our console
			// Print a statement last part of case2
			// Case 3: We don't do anything because our do-loop for choices only 1,2 not = 3
			// aka does nothing
			// Stringformat/write = Create formatted strings to line up the tests, averages, and grades, and write to the file
			switch (choice) {
            case 1:
                System.out.println("Enter grades for test1 and test2");
                System.out.println("For test 1,");
                for (int i = 0; i < 4; i++) {
                    System.out.print("Enter score " + (i + 1) + ": ");
                    testOne[i] = sc.nextInt();
                }
                System.out.println();
                System.out.println("For test 2,");
                for (int i = 0; i < 4; i++) {
                    System.out.print("Enter score " + (i + 1) + ": ");
                    testTwo[i] = sc.nextInt();
                }
                for (int i = 0; i < 4; i++) {
                    average[i] = (testOne[i] + testTwo[i]) / 2.0;
                    if (average[i] >= 90) {
                        grade[i] = 'A';
                    } else if (average[i] >= 80) {
                        grade[i] = 'B';
                    } else if (average[i] >= 70) {
                        grade[i] = 'C';
                    } else {
                        grade[i] = 'F';
                    }
                }
                System.out.println();
                System.out.println(String.format("Test 1      Test2      Average      Grade"));
                System.out.println(String.format("------      -----      -------      -----"));
                for (int i = 0; i < 4; i++) {
                	System.out.printf(String.format("%03d%-9s%03d%-9s%05.1f%-7s%S%n", testOne[i], "", testTwo[i], "", average[i], "", grade[i]));
                }
                System.out.println();
                break;
			case 2:
				System.out.println("Enter grades for test1 and test2");
				System.out.println("For test 1, ");
				for (int i = 0; i < 4; i++) {
					System.out.print("Enter score " + (i + 1) + ": ");
					testOne[i] = sc.nextInt();
				}
				System.out.println();
				System.out.println("For test 2,");
				for (int i = 0; i < 4; i++) {
					System.out.print("Enter score " + (i + 1) + ": ");
					testTwo[i] = sc.nextInt();
				}
				for (int i = 0; i < 4; i++) {
					average[i] = (testOne[i] + testTwo[i]) / 2.0;
					if (average[i] >= 90) {
						grade[i] = 'A';
					} else if (average[i] >= 80) {
						grade[i] = 'B';
					} else if (average[i] >= 70) {
						grade[i] = 'C';
					} else {
						grade[i] = 'F';
					}
				}
				System.out.print("Enter the filename:  ");
				sc.nextLine();
				fileName = sc.nextLine();
				File file = new File(fileName);
				FileWriter fw = new FileWriter(file);
				fw.write(String.format("Test 1      Test2      Average      Grade\n"));
				fw.write(String.format("------      -----      -------      -----\n"));
				for (int i = 0; i < 4; i++) {
					fw.write(String.format("%03d%-9s%03d%-9s%05.1f%-7s%S%n", testOne[i], "", testTwo[i], "", average[i], "", grade[i]));
				}
				System.out.println("Report written into a file:  " + fileName);
				fw.close();
				System.out.println();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Choice");
			}
		} while (choice != 3);
	}
}