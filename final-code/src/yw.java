import C_Stack_Queue.Queue;
import C_Stack_Queue.Stack;

import java.util.Arrays;

public class yw {
    public static void main(String[] args) {
    }

    public static int[] dataWeatrher(int[] a) {
        int n = a.length;
        int[] reuslt = new int[a.length];
        int j = 0;
        int count = 0;
        Stack stack = new Stack(a.length);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                reuslt[stack.peek()] = i - stack.peek();
                stack.pop();

            }
            stack.push(i);
        }
        return reuslt;

    }

    public static Queue modifyQueue(Queue a, int k) {
        Queue result = new Queue(a.size);
        Stack temp = new Stack(a.size);

        for (int i = 0; i < k; i++) {
            temp.push(a.dequeue());

        }

        while (!temp.isEmpty()) {
            result.enqueue(temp.pop());
        }
        while (!a.isEmpty(a)) {
            result.enqueue(a.dequeue());
        }
        return result;
    }

    public static Queue Double(Queue a, Queue b) {
        Queue result = new Queue(a.size + b.size);
        int[] dataa = new int[a.size];
        int[] datab = new int[b.size];


        for (int i = 0; i < dataa.length; i++) {
            dataa[i] = a.dequeue();


        }
        for (int i = 0; i < dataa.length; i++) {
            a.enqueue(dataa[i]);


        }
        for (int i = 0; i < datab.length; i++) {
            datab[i] = b.dequeue();


        }
        for (int i = 0; i < datab.length; i++) {
            b.enqueue(datab[i]);


        }
        int ocunta = 0;
        int ocuntb = 0;

        for (int i = 0; i < dataa.length + datab.length - 1; i++) {
            if (i % 2 == 0) {
                if (ocunta < dataa.length)
                    result.enqueue(dataa[ocunta++]);
                else result.enqueue(datab[ocuntb++]);

            } else if (ocuntb < datab.length)
                result.enqueue(datab[ocuntb++]);
            else result.enqueue(dataa[ocunta++]);

        }


        return result;
    }

    public static Queue Copy(Queue a) {
        Queue result = new Queue(a.size);
        int[] dataa = new int[a.size];

        for (int i = 0; i < dataa.length; i++) {
            dataa[i] = a.dequeue();


        }
        for (int i = 0; i < dataa.length; i++) {
            a.enqueue(dataa[i]);


        }
        for (int i = 0; i < dataa.length; i++) {
            result.enqueue(dataa[i]);
        }
        return result;
    }

    public static boolean areEqual(Queue a, Queue b) {
        Queue result = new Queue(a.size + b.size);
        int[] dataa = new int[a.size];
        int[] datab = new int[b.size];
        String coma = "";
        String comb = "";

        for (int i = 0; i < dataa.length; i++) {
            dataa[i] = a.dequeue();
            coma += dataa[i];

        }
        for (int i = 0; i < dataa.length; i++) {
            a.enqueue(dataa[i]);


        }
        for (int i = 0; i < datab.length; i++) {
            datab[i] = b.dequeue();
            comb += datab[i];

        }
        for (int i = 0; i < datab.length; i++) {
            b.enqueue(datab[i]);


        }


        return coma.compareToIgnoreCase(comb) == 0;
    }
}

//class CircularList {
//    private Node first;
//    private int size;
//
//    public CircularList() {
//        first = null;
//        size = 0;
//    }
//
//    public void add(int value) {
//        if (first == null) {
//            first = new Node(value, null);
//            first.setNext(first);
//        } else {
//            Node newNode = new Node(value, first.getNext());
//            first.setNext(newNode);
//        }
//        size++;
//    }
//
//    public void print() {
//        Node current = first;
//        while (current != null) {
//            System.out.println(current.getValue());
//            current = current.getNext();
//        }
//    }
//}