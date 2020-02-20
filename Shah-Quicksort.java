// Import For Array/Random Number
import java.util.Random;
import java.util.Arrays;

// Shahzada Shah - Data Structures
public class DataStructureLab2 {

// Method: Main To Call Everything 	
public static void main(String[] args) {

		// Declare All Variables That Will Need To Be Used Main / Generate Random Numbers
		Random r = new Random();
		int[] array = new int[100];
		int[] counter = new int[10];
		int[] counter2 = new int[10];

		// For Statement: Run Sorting 10x + Generate Array For 100 Random Numbers
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < array.length; i++) {
				array[i] = r.nextInt(99);
			}

			// Call The Bubble Sort And Store The Values That Got Swaped + Print Them
			counter[j] = bubbleSort(array);
			System.out.println("Count: " + counter[j]);
		}

		// For Statement: Calculate The Number Of Average For The Swaps
		int avg = 0;
		for (int i = 0; i < counter.length; i++) {
			avg += counter[i];
		}

		// Calculate Avg/Ten Then Print The Average Value
		avg = avg / 10;
		System.out.print("------------------------");
		System.out.println("\nAverage Comparison: " + avg);

		// Do The Same For The QuickSort (Basically Just Copy Same Format That Was Used For BubbleSort)
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < array.length; i++) {
				array[i] = r.nextInt(99);
			}

			// Print QuickSort + With Unsorted Array + Sorted + With Counter
			System.out.println("-----------FOR QUICK SORT-----------");
			System.out.print("Unsorted List:");
			printarr(array);
			counter2[j] = sort(array, 0, array.length - 1);
			System.out.print("Sorted List:");
			printarr(array);
			System.out.println("Count: " + counter2[j]);
		}

		// For Statement: Calculate The Number Of Average For The Swaps
		avg = 0;
		for (int i = 0; i < counter2.length; i++) {
			avg += counter2[i];
		}

		// Calculate Avg/Ten Then Print The Average Value
		avg = avg / 10;
		System.out.print("------------------------");
		System.out.println("\nAverage Comparison: " + avg);
	}
	
	// Method: Print Array For Ints 
	private static void printarr(int[] array) {
		for (int k = 0; k < array.length; k++) {
			System.out.print(array[k] + " ");
		}
		System.out.print("\n");
	}
	
	// Method: Bubble Sort Implementation 
	public static int bubbleSort(int[] array) {

		// Declare Variables 
		int temp;
		int counter = 0;

		// Use Print Lines To Print Unsorted + Sorted List For Bubble Sort 
		System.out.println("-----------FOR BUBBLE SORT-----------");
		System.out.print("Unsorted List: ");
		printarr(array); 
		System.out.print("Sorted List: ");
		
		// For-Loop: Run To Get The Unsorted Array, After Running Loop Next Loop Will Have Next Array Be Sorted 
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < (array.length - i - 1); j++) {
				
				// If Statement: For Two Ints Not Sorted - Use Three Way Swap + Count Swaps 
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					counter++;
				}
			}
		}
		
		// Print: The Sorted Array / Return Counter 
		printarr(array);
		return counter;
	}

	// Method: Quick Sort Implementation 
	public static int partition(int array[], int low, int high) {

		// Use Right Element As Pivot 
		int pivot = array[high];
        int i = (low - 1); 
       
        // ForLoop: Move Elements Around Pivot, Until Everything Ends All On The Left, Left Lower, Right Higher 
        //(Divide And Conquer) (3 Way Swap) (Count Swaps)
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Keeping Swaping + Return Final Pivot Location 
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

	// Method: Recursive Sorting For Quick Sort
	public static int sort(int array[], int low, int high) {

		// If Statement: Low Is Less Than High
		// Int Pi = Value (Partition) 
		// (Count) Value Will Be = (High-Low)
		// Try Partition SubArray + Get Back Pivot Position 
		if (low < high) {
            int pi = partition(array, low, high);
            int count = high - low;
 
            // Since All Elements On The Left Are Low, Separately Sort Elements Before Partition/After Partition (Return Count)
            count += sort(array, low, pi - 1);
            count += sort(array, pi + 1, high);
            return count;
        }
        return 0;
    }
}

// Citation: 
// QuickSort: 
// https://www.geeksforgeeks.org/quick-sort/
// http://www.java2novice.com/java-sorting-algorithms/quick-sort/
// https://www.geeksforgeeks.org/insertion-sort/ (Helper Class) 
// BubbleSort: 
// https://www.geeksforgeeks.org/java-program-for-bubble-sort/
// https://www.javatpoint.com/bubble-sort-in-java
// Main Method For Array + Generate Random Numbers:
// http://www.java2s.com/Tutorials/Java/Collection_How_to/Array/Fill_an_array_with_random_numbers.htm