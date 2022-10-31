package A_Sorting;

public class merge_sort {
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] == R[j]) {
                System.out.println("this is not disjoint");
            }
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            // the thing in here imagin the array has 2 pointer
            // the first pointer stay of the left of the first array
            // the second pointer stay on ther right of the second array
            // we will check if left>right copy right into array increasr right pointer to 1
            // if right >left copy left into array
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] =// {100, 54, 545, 42, 12, 486594, 89, 264, 84, 21, 64, 61, 32, 4685, 489, 4789, 4, 89, 5641, 321, 489, 654, 32156, 456, 465, 49847, 89, 75, 89, 74, 6241, 684, 9854, 6541, 65, 165, 45684, 654, 1651, 564, 9864, 69854, 561, 6531, 89654, 6541, 654, 6859};
                {1, 2, 3};
        System.out.println("Given Array");
        printArray(arr);

        merge_sort ob = new merge_sort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
        // wrotse case o(nlogn)
    }
}
