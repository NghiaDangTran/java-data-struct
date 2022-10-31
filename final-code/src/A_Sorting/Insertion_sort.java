package A_Sorting;

import java.util.Arrays;

public class Insertion_sort {
    public static void main(String[] args) {
        //
        int[] data = {7, 4, 6, 5, 8, 3, 2, 9};
        Selection_sort(data);
        System.out.println(Arrays.toString(data));
        // System.out.println(21%9);
    }

    public static void Insertion_sort(int[] data) {
        int siftValue;
        int j;
        for (int i = 1; i < data.length; i++) {
            siftValue = data[i];

            j = i - 1;
            while (j >= 0 && data[j] > siftValue) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = siftValue;


        }
        // the worste case reuning o(n*n) usefull for small list or nearly sorted one
    }

    public static void Selection_sort(int[] data) {
        int largest, temp;
        for (int i = 0; i < data.length - 1; i++) {
            System.out.println(Arrays.toString(data));
            largest = 0;
            for (int j = 0; j < data.length - i; j++) {
                if (data[largest] < data[j])
                    largest = j;
            }
            temp = data[data.length - 1 - i];
            data[data.length - 1 - i] = data[largest];
            data[largest] = temp;
        }

        //worst case ins O(n*n) Note that O(n2) comparisons are done but only O(n) data moves.  Use selection over insertion if moving data is costl
    }

    public static void bubble_sort(int[] data) {
        int temp;
        for (int i = 0; i < data.length - 1; i++)
            for (int j = 0; j < data.length - 1 - i; j++)
                if (data[j] < data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
        //wroste case O(n^2);
    }

    public class merge_sort {
        public merge_sort(int[] data) {

        }

    }
}

