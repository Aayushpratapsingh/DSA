public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // Select the current element to be inserted
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // Insert the key in its correct position
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 3}; // Input array

        // Print array before sorting in a single line
        System.out.print("Before Sorting: ");
        printArray(arr);

        insertionSort(arr); // Perform insertion sort

        // Print array after sorting in a single line
        System.out.print("After Sorting: ");
        printArray(arr);
    }

    // Helper method to print the array in a single line
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println(); // Move to the next line after printing
    }
}