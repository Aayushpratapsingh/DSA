public class Main {
    
    public static void selectionSort(int[] arr) {
        //  int n = arr.length;
         for (int i = 0; i < arr.length - 1; i++) {
             int minIndex = i;
             for (int j = i + 1; j < arr.length; j++) {
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
             int[] arr = {5, 1, 3, 4, 2}; 
             Main.selectionSort(arr); 
             for (int i = 0; i < arr.length; i++) {
                 System.out.print(arr[i] + " ");
             }
     }
         
 }