// Import Scanner 
import java.util.Scanner;

//Shahzada Shah - Data Structures
public class DataStructureLab1 {

// Method: Main To Call Everything 		
public static void main(String[] args) {

		// Declare Variables
		// Make String close variable - "Done" to stop the program
		// Make boolean condition for the while loop
		// Make scanner to read inputs
		String input;
		String close = "done";
		boolean condition = true;
		Scanner scan = new Scanner(System.in);

		// Make a while statement, and have the condition = true to keep running
		// Have user type in the input to find out if it will be a palindrone or not
		while (condition == true) {
			String reverse = "";
			System.out.println("Enter the text to reverse to see if it a palindrome");
			input = scan.nextLine();

			// Make if statement compare input and close to see if they are equal
			// If they are, the condition will be false and the program will break aka close
			if (input.equals(close)) {
				condition = false;
				break;

				// Make else statement to run the program if the program is not terminated from
				// the condition being false
				// Reverse you're input with the for statement being used and then use a if
				// statement
				// To test if the input is a palindrome or not
			} else {

				for (int i = input.length() - 1; i >= 0; i--)
					reverse = reverse + input.charAt(i);

				System.out.println("Reverse of the text is: " + reverse);

				if (input.equals(reverse)) {
					System.out.println(input + " is a palindrome");
				} else {
					System.out.println(input + " is not a palindrome");
				}
			}
		}
	}
}

// Citation Links:
// https://www.youtube.com/watch?v=PG79LY41BQ8
// https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
// https://www.w3schools.in/java-tutorial/loops/while/
// https://www.youtube.com/watch?v=UZdWGHQ7hY0