package F_Heap_Class;

import java.util.Arrays;

public class MinHeap {
    public static void main(String[] arg) {
        //        MaxHeapclass maxHeap = new MaxHeapclass(15);
        //        maxHeap.insert(74);
        //        maxHeap.insert(5);
        //        maxHeap.insert(26);
        //        maxHeap.insert(43);
        //        maxHeap.insert(89);
        //        maxHeap.insert(52);
        //        maxHeap.insert(68);
        //        System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());  System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());System.out.println(maxHeap.deleteMax());System.out.println(maxHeap.deleteMax());
        //        maxHeap.insert(66);
        //        maxHeap.insert(67);
        //        System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());  System.out.println(maxHeap.deleteMax());
        //        maxHeap.print();
        //        maxHeap.Printarr();
        /********************************************Connect `n` ropes with minimal cost
         *////
        //
        //        int[] arr = {5, 4, 2, 8};
        //        MinHeapclass maxHeap = new MinHeapclass(arr.length * 3);
        //        for (int i = 0; i < arr.length; i++)
        //            maxHeap.insert(arr[i]);
        //        maxHeap.Printarr();
        //        int result = 0;
        //
        //        while (maxHeap.heapSize > 1) {
        //            int x = maxHeap.deleteMax();
        //            int y = maxHeap.deleteMax();
        //
        //
        //            result += x + y;
        //            maxHeap.insert(x + y);
        //
        //        }
        //
        //        System.out.println(result);
        // K_largest_ele(maxHeap,2);
        ///////////k largest elements///////////
        /*** Replace each array element by its corresponding rank
         */
        //        int[] arr = {10, 8, 15, 12, 6, 20, 1};
        //        MinHeapclass maxHeap = new MinHeapclass(arr.length * 3);
        //        for (int i = 0; i < arr.length; i++)
        //            maxHeap.insert(arr[i]);
        //        maxHeap.Printarr();
        //        int count = 1;
        //        while (!maxHeap.isEmpty()) {
        //            int temp = maxHeap.deleteMax();
        //
        //            for (int i =0;i< arr.length;i++) {
        //                if (arr[i] == temp)
        //                    arr[i] = count;
        //            }
        //            count++;
        //
        //
        //        }
        //        System.out.println(Arrays.toString(arr));
        /** *****  Sort a k-sorted array         */

        //                int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        //                MinHeapclass maxHeap = new MinHeapclass(arr.length * 3);
        //                for (int i = 0; i < arr.length; i++)
        //                    maxHeap.insert(arr[i]);
        //                maxHeap.Printarr();
        /**   Convert max heap to min heap in linear time    **/
        int[] arr = {9, 4, 7, 1, -2, 6, 5 };
        MinHeapclass maxHeap = new MinHeapclass(arr.length );
        for (int i = 0; i < arr.length; i++)
            maxHeap.insert(arr[i]);
        maxHeap.Printarr();


    }
}

class MinHeapclass {

    private int[] heap;
    int heapSize; // number of items currently in the heap
    int maxItems;

    public MinHeapclass(int maxSize) {
        maxItems = maxSize;
        heap = new int[maxSize];

        heapSize = 0;
    } // end constructor


    public boolean isEmpty() {
        return heapSize == 0;
    } // end isEmpty


    public boolean isFull() {
        return heapSize >= heap.length;
    } // end isFull


    /************************************************************
     * parent
     *
     * PURPOSE:
     *    Returns the index of the parent of the item at index i
     *    (doesn't check if there is a parent).
     *
     ************************************************************/
    public static int parent(int i) {
        return (i - 1) / 2;
    } // end parent


    /************************************************************
     * rightChild
     *
     * PURPOSE:
     *    Returns the index of the right child of the
     *    item at index i (doesn't check if there is a
     *    right child).
     ************************************************************/
    public static int rightChild(int i) {
        return 2 * i + 2;
    } // end rightChild


    /************************************************************
     * leftChild
     *
     * PURPOSE:
     *    Returns the index of the left child of the
     *    item at index i (doesn't check if there is a
     *    left child).
     ************************************************************/
    public static int leftChild(int i) {
        return 2 * i + 1;
    } // end leftChild


    /*************************************************************
     *
     * insert
     *
     * PURPOSE: Add a new item to the heap.
     *
     ******************************************************************/
    public void insert(int priority) {

        if (isFull()) {
            int[] temp = new int[maxItems];
            for (int i = 0; i < heapSize; i++) {
                temp[i] = heap[i];
            }
            maxItems = maxItems * 2;

            heap = new int[maxItems];
            for (int i = 0; i < temp.length; i++) {
                heap[i] = temp[i];
            }

        }
        heap[heapSize] = priority;
        heapSize++;
        siftUp(heapSize - 1);

    } // end insert

    /*************************************************************
     *
     * siftUp
     *
     * PURPOSE:
     *    The item at heap[index] may have higher priority
     *    than its parent, but no other problems exist in the heap.
     *    Restore heap order by repeatedly moving its parent down
     *    until either:
     *    (1) the root was moved down, or
     *    (2) its parent's priority is >= its priority.
     *    Put the item into the "hole" created by the item last
     *    moved down.
     *
     ******************************************************************/
    private void siftUp(int index) {
        int toSift = heap[index]; // make a "hole" in the heap
        int i = index;
        int iParent = parent(index);

        while (i > 0 && heap[iParent] > toSift) {
            heap[i] = heap[iParent]; // move the "hole" up to the parent
            i = iParent;
            iParent = parent(i);
        } // end while
        heap[i] = toSift; // put the sifted item into the correct position

    } // end siftUp

    private boolean isLeaf(int pos) {
        if (pos > (heapSize / 2) && pos <= heapSize) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // A recursive function to max heapify the given
    // subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need
    // to fix the root.
    private void siftDown(int pos) {
        int largest = pos;
        int l = leftChild(pos);
        int r = rightChild(pos);
        if (l < heapSize && heap[l] < heap[largest])
            largest = l;
        if (r < heapSize && heap[r] < heap[largest])
            largest = r;
        if (largest != pos) {
            int swap = heap[pos];
            heap[pos] = heap[largest];
            heap[largest] = swap;

            // Recursively heapify the affected sub-tree
            siftDown(largest);
        }
    }


    public int deleteMax() {
        int result = heap[0];
        if (!isEmpty()) {
            heap[0] = heap[heapSize - 1];
            heapSize--;
            siftDown(0);
        } else return Integer.MIN_VALUE;

        return result;

    }

    public void Printarr() {
        System.out.println(Arrays.toString(heap));

    }

    public void print() {
        // System.out.println(heapSize);

        for (int i = 0; i < heapSize / 2; i++) {
            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i + 1]
                            + " RIGHT CHILD :" + heap[2 * i + 2]);
            System.out.println();
        }
    }

    //    public static void K_largest_ele(MaxHeapclass heap, int n) {
    //        for (int i = 0; i < n; i++)
    //            System.out.print(heap.deleteMax() + " ");
    //
    //
    //    }


    public static void main(String[] arg) {
        //        MaxHeapclass maxHeap = new MaxHeapclass(15);
        //        maxHeap.insert(74);
        //        maxHeap.insert(5);
        //        maxHeap.insert(26);
        //        maxHeap.insert(43);
        //        maxHeap.insert(89);
        //        maxHeap.insert(52);
        //        maxHeap.insert(68);
        //        System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());  System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());System.out.println(maxHeap.deleteMax());System.out.println(maxHeap.deleteMax());
        //        maxHeap.insert(66);
        //        maxHeap.insert(67);
        //        System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());
        //        System.out.println(maxHeap.deleteMax());  System.out.println(maxHeap.deleteMax());
        //        maxHeap.print();
        //        maxHeap.Printarr();
        /********************************************Connect `n` ropes with minimal cost
         *////

        int[] arr = {5, 4, 2, 8};
        MinHeapclass maxHeap = new MinHeapclass(arr.length * 3);
        for (int i = 0; i < arr.length; i++)
            maxHeap.insert(arr[i]);
        maxHeap.Printarr();
        int result = 0;

        while (maxHeap.heapSize > 1) {
            int x = maxHeap.deleteMax();
            int y = maxHeap.deleteMax();


            result += x + y;
            maxHeap.insert(x + y);

        }

        System.out.println(result);
        // K_largest_ele(maxHeap,2);
        ///////////k largest elements///////////


    }
} // end class MaxHeap
/****
 *Connect `n` ropes with minimal cost        https://www.techiedelight.com/connect-n-ropes-with-minimal-cost/  [5, 4, 2, 8]  [5, 4, 2, 8]  [5, 6, 8]   [11, 8]    6 + 11 + 19 = 36.
 *Return k’th largest element in a stream     https://www.techiedelight.com/return-kth-largest-element-stream/
 * 4 The k’th largest element is NA.
 * 5 The k’th largest element is NA.
 * 12 The k’th largest element is 4
 * 8 The k’th largest element is 5
 * 9 The k’th largest element is 8
 * 10The k’th largest element is 9
 * 20 The k’th largest element is 10
 * 42 The k’th largest element is 12
 * …
 *
 *
 *
 *
 *
 *
 *
 *
 * *
 * *
 * *
 * **
 * *
 *
 *


 */

