package F_Heap_Class;

import java.util.Arrays;

class MaxHeap {
    public static void main(String[] arg) {
        //        Maxheapclass data = new Maxheapclass(1);
        //        int[] array = {10, 8, 15, 12, 6, 20, 1
        //        };
        //        for (int i : array)
        //            data.insert(i);
        //        data.Printarr();
        //
        //
        //        int[] data1 = {7, 4, 6, 3, 9, 1};
        //        data.kth_largest(data1, 3);
        Maxheapclass data = new Maxheapclass(1);
        int[] array = {45, 30, 40, 15, 20, 25, 35
        };
        for (int i : array)
            data.insert(i);
        data.Printarr();
        data.deleteMax();
        data.Printarr();

    }

} //

class Maxheapclass {
    /********************** Importance note this class is the same wil my lab 11 **************************************/////////////
    /********************** Importance note this class is the same wil my lab 11 **************************************/////////////
    /********************** Importance note this class is the same wil my lab 11 **************************************/////////////
    /********************** Importance note this class is the same wil my lab 11 **************************************/////////////
    /********************** Importance note this class is the same wil my lab 11 **************************************/////////////
    // for convinience I just reuse the code on the max heap section in the zybook
    int maxSizeheap;// the total sime of the heap
    private int[] heap;// heap contain all the patient
    private int heapSize; // number of items currently in the heap

    public Maxheapclass(int maxSize) {
        maxSizeheap = maxSize;
        heap = new int[maxSize];
        //  Arrays.fill(heap, Integer.MIN_VALUE);
        heapSize = 0;
    } // end constructor

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

    public boolean isEmpty() {
        return heapSize == 0;
    } // end isEmpty

    public boolean isFull() {
        return heapSize >= heap.length;
    } // end isFull

    /*************************************************************
     *
     * insert
     *
     * PURPOSE: Add a new item to the heap.
     *
     ******************************************************************/
    public void insert(int priority) {

        if (isFull()) {
            // System.out.println(1);
            int[] temp = new int[maxSizeheap];
            for (int i = 0; i < heapSize; i++) {
                temp[i] = heap[i];
            }
            maxSizeheap = maxSizeheap * 2;
            //     Arrays.fill(heap, Integer.MIN_VALUE);

            heap = new int[maxSizeheap];
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

        while (i > 0 && heap[iParent] < toSift) {
            //System.out.println(Arrays.toString(heap));
            heap[i] = heap[iParent]; // move the "hole" up to the parent
            i = iParent;
            iParent = parent(i);
        } // end while
        heap[i] = toSift; // put the sifted item into the correct position

    } // end siftUp

    /*************************************************************
     *
     * siftDown
     *
     * PURPOSE:
     *       sift the itme that we reamoved in the root down to the
     *       right positon
     *
     ******************************************************************/
    private void siftDown(int at) {
        int curr = at;
        int l = leftChild(at);// the left child of the node
        int r = rightChild(at);// the right child
        if (l < heapSize && heap[l] > heap[curr])
            curr = l;// if the left node is mor importance then the right move to the left
        if (r < heapSize && heap[r] > heap[curr])
            curr = r;
        // orther wise move to the right
        if (curr != at) {
            // if the curr is not the same with with the  at
            // then swap it
            int temp = heap[at];
            heap[at] = heap[curr];
            heap[curr] = temp;

            siftDown(curr);//recresive untill it is the same
        }

    }

    /*************************************************************
     *
     * peek
     *
     * PURPOSE:
     *       return the first person that has the most priority in the array
     *
     ******************************************************************/
    public int peek() {
        return heap[0];
    }

    /*************************************************************
     *
     * deleteMax
     *
     * PURPOSE:
     *       delete the array 0
     *       and move orther to that new biggest
     *
     ******************************************************************/

    public int deleteMax() {
        int result = heap[0];
        if (!isEmpty()) {
            heap[0] = heap[heapSize - 1];
            heapSize--;
            // remove that value wil the last positon at the
            // array
            siftDown(0);//also sift taht value down the array
        } else
            heap = new int[maxSizeheap];// this is just a safe way to clean up array
        return result;
        // after all return the patient

    }

    /*************************************************************
     *
     * Printarr
     *
     * PURPOSE:
     *       print all the value in the array
     *
     ******************************************************************/

    public void Printarr() {
        System.out.println(Arrays.toString(heap));

    }

    /*************************************************************
     *
     * Find k’th largest element in an array
     *
     *
     *
     ******************************************************************/

    public void kth_largest(int[] arr, int k) {
        Maxheapclass data = new Maxheapclass(3);
        int count = 0;

        for (int i = 0; i < arr.length; i++)
            data.insert(arr[i]);
        data.Printarr();
        int result = 0;

        while (count != k) {
            result = data.deleteMax();
            count++;

        }
        System.out.println(result);
    }

    //    public void changePriority(IdNum id,int a) {
    //        int found = -1;
    //        for (int i = 0; i < heapSize; i++)
    //            if (heap[i].IdNum == id)
    //                found = i;
    //
    //            if (found >= 0) {
    //                if (!isEmpty()) {
    //                    heap[found] = heap[heapSize - 1];
    //                    heapSize--;
    //
    //                    siftDown(found);
    //                } else
    //                    heap = new int[maxSizeheap];
    //                insert(new PrintJob(id,a));
    //            }
    //
    //    }
}

class so {
    //94,64,61,53,50
    //    64, 53, 61, 50, 94
    //            61, 53, 50, 64, 94
    //            53, 50, 61, 64, 94
    //            50, 53, 61, 64, 94

}