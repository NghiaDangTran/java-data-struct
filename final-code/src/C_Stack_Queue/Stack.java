package C_Stack_Queue;

public class Stack {
    //easy to do
    private int size;
    private int[] data;

    public Stack(int maxSize) {
        data = new int[maxSize];
        size = 0;
    }


    public boolean contain(int a) {
        for (int i = 0; i < data.length; i++)
            if (data[i] == a)
                return true;

        return false;
    }

    public void push(int value) {

        data[size] = value;
        size++;
    }


    public int pop() {

        size--;
        return data[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        int top = pop(); // Get the top
        push(top);       // Put it back
        return top;
    }

    public void clear() {
        // size = 0; is O(1)
        // This is O(n):
        while (!isEmpty())
            pop(); // Ignore the result
    }

    public void print() {
        for (int i = 0; i < size; i++)
            System.out.print(data[i] + " ");
        System.out.println();


    }

    public void swap() {
        int top, second;
        top = pop();
        second = pop();
        push(top);    // Push the top first
        push(second); // The second becomes the top
    }


    public Stack copy() {
        Stack result = new Stack(data.length);

        for (int i = 0; i < data.length; i++)
            result.push(data[i]);
        return result;

    }

    public Stack Copy2(int curr) {
        Stack result = new Stack(data.length);
        if (curr < data.length) {
            result.push(curr);
            result = Copy2(curr + 1);
        }
        return result;
    }
}
