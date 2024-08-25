import java.util.*;

public class ArrayNullification {

    public static int getMin(List<Integer> change, List<Integer> arr) {
        // Convert arr to an ArrayList to handle nulls
        List<Integer> arrList = new ArrayList<>(arr);

        int operations = 0;
        int n = change.size();
        int nonNullCount = arrList.size();

        for (int i = 0; i < n; i++) {
            int index = change.get(i);

            // Adjust the index to be zero-based
            index--;

            // Decrement the element if it's not already NULL
            if (index >= 0 && index < arrList.size() && arrList.get(index) != null) {
                if (arrList.get(index) > 0) {
                    arrList.set(index, arrList.get(index) - 1);
                }

                // Check if we should set the element to NULL
                if (arrList.get(index) != null && arrList.get(index) == 0) {
                    arrList.set(index, null);
                    nonNullCount--;
                }
            }

            operations++;

            // Debugging statement to trace the internal state
            System.out.println("Operation " + operations + ": " + arrList);

            // If all elements are NULL, return the operations count
            if (nonNullCount == 0) {
                return operations;
            }
        }

        // If we completed all operations but not all elements are NULL, return -1
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> change = new ArrayList<>();
       
        List<Integer> arr = new ArrayList<>();
        System.out.println(getMin(change, arr)); // Output should be checked
    }
}

