public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {55, 34, 12, 27, 11}; // Input array

        // Print array before sorting in a single line
        System.out.print("Before Sorting: ");
        printArray(arr);

        selectionSort(arr); // Perform selection sort

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