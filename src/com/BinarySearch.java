public class BinarySearch {
    /**
     * Search a sorted array by repeatedly dividing the search interval in half.
     */

    public static void main(String[] args) {

        BinarySearch ob = new BinarySearch();
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int search = 10;
        int result = ob.binarySearch(arr, 0, n - 1, search);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index: " + result);

    }

    int binarySearch(int arr[], int start, int end, int search) {
        if (end >= start) {
            int mid = start + (end - start) / 2;

            // If the element is present at the middle itself
            if (arr[mid] == search)
                return mid;

            // If element is smaller than mid, then it can only be present in left subarray
            if (arr[mid] > search)
                return binarySearch(arr, start, mid - 1, search);

            // Else the element can only be present in right subarray
            return binarySearch(arr, mid + 1, end, search);
        }

        // We reach here when element is not present in array
        return -1;
    }

}
