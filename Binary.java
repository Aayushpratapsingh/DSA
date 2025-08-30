public class Binary {
    static int BinarySearch(int[] arr, int tar) {
        int st = 0;
        int end = arr.length - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (tar > arr[mid])
                st = mid + 1;
            else if (tar < arr[mid])
                st = mid - 1;
            else
                return mid;

        }
        return -1;

    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int tar = 3;
        int result = BinarySearch(arr, tar);
        System.out.println(result);

    }
}
