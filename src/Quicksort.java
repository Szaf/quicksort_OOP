import java.util.ArrayList;
import java.util.Random;
/**
 * Quicksort in an OOP way
 * @author Andrej
 *
 */
public class Quicksort {
	private static int length = 10;
	private ArrayList<Integer> numbers;
	
	/**
	 * Create List of random numbers,
	 * print them, sort them and
	 * print the sorted list.
	 * @param args
	 */
	public static void main(String[] args) {
		Quicksort quickSort = new Quicksort();
		quickSort.generateRandomArrayList(length);
		System.out.println("Unsorted: " + quickSort.getNumbers());
		ArrayList<Integer> sorted = quickSort.sort(quickSort.getNumbers());
		System.out.println("Sorted:   " + sorted);
	}

	/**
	 * Recursive method, that gets a list, choose the pivot element
	 * and divide into two lists:
	 *  - one with elements < pivot element
	 *  - one with elements >= pivot element
	 * Call method for both lists separate, clear initial list 
	 * and combine all lists.
	 * 
	 * IMPORTANT: delete pivot element before dividing into two lists
	 * and ofc don't forget the termination condition (if one list 
	 * holds <=1 element)
	 * 
	 * @param list
	 * @return
	 */
	private ArrayList<Integer> sort(ArrayList<Integer> list) {
		int length = list.size();
		if (length <=1){return list;}
		int pivot = list.get(list.size()/2);
		list.remove(list.size()/2); // Delete pivot element to prevent infinite loop
		ArrayList<Integer> lower = new ArrayList<Integer>(); // can i combine both lines?
		ArrayList<Integer> upper = new ArrayList<Integer>();
		for (int i = 0; i<length-1; i++){
			int element = list.get(i);
			if(element<pivot){
				lower.add(element);
			}
			else { upper.add(element);}
		}
		lower = sort(lower);
		upper = sort(upper);

		// Sort numbers
		list.clear(); 
		list.addAll(lower);
		list.add(pivot);
		list.addAll(upper);
		return list;
	}

	/**
	 * Create a list of random numbers
	 * @param length
	 */
	public void generateRandomArrayList(int length){
		ArrayList<Integer> unsorted_numbers = new ArrayList<Integer>(length);
		Random rand = new Random();
		for (int i = 0; i<length; i++){ 
			Integer number = rand.nextInt(200);
			unsorted_numbers.add(number);
		}
		this.numbers = unsorted_numbers;
	}

	/**
	 * Return the list of numbers
	 * @return
	 */
	public ArrayList<Integer> getNumbers() {
		return numbers;
	}
}