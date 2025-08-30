public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2}; // Input array

        // Print array before sorting in a single line
        System.out.print("Before Sorting: ");
        printArray(arr);

        bubbleSort(arr); // Perform bubble sort

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