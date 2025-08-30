// public class Bubble{
//     void bubbleSort(int arr[], int n ){
//         for (int i = 0; i<n-1; i++){
//             for (int j = 0; j < n-i-1; j++){
//                 if (arr[j] > arr[j+1]){
//                     // swap (arr[j], arr[j+1]) 
//                     int temp = arr[j];
//                     arr[j] = arr[j+1];
//                     arr[j+1] = temp;

//                 }
//             }
//         }
//     }
//     public static void main(String[] args) {
//         int[] arr={4,1,6,7,2};
//         Bubble b = new Bubble();
//         int n = arr.length;
//                 b.bubbleSort(arr, n);
//         for (int i = 0; i < n; i++) {
//             System.out.print(arr[i] + " ");
//             }
//     }
// }

public class Bubble {
    void bubbleSort(int arr[]) {
        int n = arr.length; // Get the size of the array
        for (int i = 0; i < n - 1; i++) { // Outer loop for passes
            for (int j = 0; j < n - i - 1; j++) { // Inner loop for comparing elements
                if (arr[j] > arr[j + 1]) { // Swap if the current element is greater than the next
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 6, 7, 2 };
        Bubble sorter = new Bubble();
        sorter.bubbleSort(arr); // Call the sorting function

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
