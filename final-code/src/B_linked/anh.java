package B_linked;

public class anh {
    public static void main(String args[]) {
        //Node as = new LINKED_List();

        LINKED_List first = new LINKED_List();
        first.append(9);
        first.append(10);
        first.append(11);
        first.append(12);

        // first.sumrest();     //   LINKED_List second = first.splitList();
        // first.printList();
        LINKED_List second = new LINKED_List();
        second.push(1);        //        first.setNext(new LINKED_List.Node(4, null));
        second.push(2);        //        first.setNext(new LINKED_List.Node(4, null));
        second.push(3);        //        first.setNext(new LINKED_List.Node(4, null));
        second.push(4);
        Node a = new Node(1);
        a.next = new Node(3);
        a.next.next = new Node(5);

        Node b = new Node(0);
        b.next = new Node(2);
        b.next.next = new Node(4);


        Node c = new Node(0);
        c =LINKED_List. orderDifference(a, b);

        System.out.println(LINKED_List.checkSort(a));


        LINKED_List third = first.append(first, second);
        third.printList();

        //        first.setNext(new LINKED_List.Node(4, null));
        //        firs       first.printList();t.getNext().setNext(new .Nod(0, null));
        //        .get).getNext().getNext().setNext(new LINKED_List.Node(2, null));
        //
        //        LINKED_List.Node second = LINKED_List.splitList(first);
        //        System.out.println(first.getData());
        //        System.out.println(first.getNext().getData());
        //        System.out.println(first.getNext().getNext().getData());
        //        System.out.println(first.getNext().getNext().getNext().getData());
        //        System.out.println(first.getNext().getNext().getNext().getNext().getData());
        //        System.out.println(second.getData());
        //        System.out.println(second.getNext().getData());
        //        System.out.println(second.getNext().getNext().getData());
        //        DLL dll = new DLL();
        //
        //        // Insert 6. So linked list becomes 6->NULL
        //        dll.append(6);
        //
        //        // Insert 7 at the beginning. So
        //        //linked list becomes 7->6->NULL
        //        dll.push(7);
        //
        //        // Insert 1 at the beginning. So
        //        // linked list becomes 1->7->6->NULL
        //        dll.push(1);
        //
        //        // Insert 4 at the end. So linked
        //        // list becomes 1->7->6->4->NULL
        //        dll.append(4);
        //
        //        // Insert 8, after 7. So linked
        //        // list becomes 1->7->8->6->4->NULL
        //        dll.InsertAfter(dll.head.next, 8);
        //
        //        System.out.println("Created DLL is: ");
        //        dll.printlist(dll.head);

    }

    ////// circular
    public static boolean checkCircle(LINKED_List a) {
        Node curr = a.head;
        Node prev = a.head;
        if (curr == null)
            return false;

        while (curr != null && curr.next != null) {
            prev = prev.next;
            curr = curr.next.next;
            if (prev == curr)
                return true;


        }
        return false;

    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LINKED_List {
    static boolean checkSort(Node a) {
        if (a == null || a.next == null)
            return true;
        return (a.data < a.next.data) && checkSort(a.next);
    }

    static Node orderDifference(Node a, Node b) {

        if (a == null)
            return b;
        if (b == null)
            return a;
        Node result;
        if (a.data < b.data) {
            result = b;
            result.next = orderDifference(a, b.next);

        } else {
            result = a;
            result.next = orderDifference(a.next, b);
        }

        return result;


    }

    Node head;  // head of list

    /* Linked list Node*/

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prev_node, int new_data) {
        /* 1. Check if the given Node is null */
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        /* 2 & 3: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;

        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }

    /* Appends a new node at the end.  This method is
       defined inside LinkedList class shown above */
    public void append(int new_data) {
        /* 1. Allocate the Node &
           2. Put in the data
           3. Set next as null */
        Node new_node = new Node(new_data);

        /* 4. If the Linked List is empty, then make the
              new node as head */
        if (head == null) {
            head = new Node(new_data);
            return;
        }

        /* 4. This new node is going to be the last node, so
              make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }

    public LINKED_List splitList() {
        Node curr = head;
        // curr = curr.next;
        LINKED_List result = new LINKED_List();

        int count = 0;
        while (curr != null) {
            if (count % 2 == 0) {
                //   System.out.println(curr.item);
                result.push(curr.data);
            }
            count++;

            curr = curr.next;

        }
        return result;
    }

    public LINKED_List doubleList(LINKED_List a, LINKED_List b) {
        LINKED_List result = new LINKED_List();
        Node curr = a.head;

        while (curr != null) {

            result.push(curr.data);


            curr = curr.next;

        }
        curr = b.head;
        while (curr != null) {

            result.push(curr.data);


            curr = curr.next;

        }


        return result;

    }

    public LINKED_List append(LINKED_List a, LINKED_List b) {
        LINKED_List result = new LINKED_List();
        Node curra = a.head;
        Node currb = b.head;

        int count = 0;

        while (curra != null || currb != null) {

            if (count % 2 == 0) {
                result.append(curra.data);
                curra = curra.next;
            } else {
                result.append(currb.data);

                currb = currb.next;
            }
            count++;
        }

        return result;
    }

    public void sumrest() {
        Node curr = head;
        LINKED_List data1 = new LINKED_List();

        while (curr != null) {
            Node newcurr = curr;
            int a = 0;
            while (newcurr != null) {
                a += newcurr.data;
                newcurr = newcurr.next;

            }
            Node next = curr.next;
            //  System.out.println(a);
            curr = new Node(a);
            curr.next = next;
            data1.append(a);
            //    System.out.println(curr.data);
            curr = curr.next;


        }


        head = data1.head;

        // head=curr;
    }

    /* This function prints contents of linked list starting from
        the given node */
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }
}

class DLL {
    Node head; // head of list

    /* Doubly Linked list Node*/
    class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node(int d) { data = d; }
    }

    // Adding a node at the front of the list
    public void push(int new_data) {
        /* 1. allocate node
         * 2. put in the data */
        Node new_Node = new Node(new_data);

        /* 3. Make next of new node as head and previous as NULL */
        new_Node.next = head;
        new_Node.prev = null;

        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = new_Node;

        /* 5. move the head to point to the new node */
        head = new_Node;
    }

    /* Given a node as prev_node, insert
    a new node after the given node */
    public void InsertAfter(Node prev_Node, int new_data) {

        /*1. check if the given prev_node is NULL */
        if (prev_Node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        /* 2. allocate node
         * 3. put in the data */
        Node new_node = new Node(new_data);

        /* 4. Make next of new node as next of prev_node */
        new_node.next = prev_Node.next;

        /* 5. Make the next of prev_node as new_node */
        prev_Node.next = new_node;

        /* 6. Make prev_node as previous of new_node */
        new_node.prev = prev_Node;

        /* 7. Change previous of new_node's next node */
        if (new_node.next != null)
            new_node.next.prev = new_node;
    }

    // Add a node at the end of the list
    void append(int new_data) {
        /* 1. allocate node
         * 2. put in the data */
        Node new_node = new Node(new_data);

        Node last = head; /* used in step 5*/

        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        new_node.next = null;

        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;

        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }


    // This function prints contents of
    // linked list starting from the given node
    public void printlist(Node node) {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }

    /* Driver program to test above functions*/
}

class LINKED_List_ttesr {


    private Node top;
    private int size;

    public LINKED_List_ttesr() {
        top = null;
        size = 0;
    }

    public String toString() {

        Node begin = top;
        String S = "";
        while (begin != null) {
            S += begin.getData() + " ";
            begin = begin.getNext();
        }
        return S;
    }


    public void modifyList() {

        Node prev = null;
        Node curr = top;


        while (curr != null) {


            if (curr.getData() % 2 == 0) {

                if (prev == null) {
                    top = new Node(curr.getData(), curr);
                } else {
                    Node temp = new Node(curr.getData(), curr);
                    prev.setNext(temp);
                    System.out.println(temp);

                }


            }

            prev = curr;
            curr = curr.getNext();

        }

        removeOdds();

    }


    public void removeOdds() {
        Node cur = top;
        Node previous = cur;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.getData() % 2 != 0) {
                size--;
                previous.next = cur.next;
            } else {
                previous = previous.next;
            }
        }
    }

    public boolean isEmpty() {
        return top == null;

    }

    public void insertLast(int newIndex) {
        Node temp = top;
        Node curr = new Node(newIndex, null);

        if (top == null) {
            top = curr;
            size++;

        } else {
            while (temp != null) {
                if (temp.next == null) {
                    System.out.println(temp.getData());
                    temp.setNext(curr);
                    size++;
                    break;
                }

                temp = temp.getNext();
            }
        }
    }

    public void printMiddle() {
        Node slow_ptr = top;
        Node fast_ptr = top;
        if (top != null) {
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                    slow_ptr.getData() + "] \n");
        }
    }

    public void insertUnordered(int newItem) {
        top = new Node(newItem, top);
        size++;
    }

    public void insertOrdered(int newItem) {
        size++;

        Node prev = null;
        Node curr = top;

        while (curr != null && curr.item < newItem) {
            prev = curr;
            curr = curr.next;
        }
        Node newNode = new Node(newItem, curr);
        if (prev != null)
            prev.next = newNode;
        else
            top = newNode;


    }

    Node find(int key) {
        Node curr = top;
        while (curr != null && curr.item != key)
            curr = curr.next;
        if (curr != null && curr.getData() != key)
            curr = null;
        return curr;
    }

    public void delete_first() {
        top = top.next;
        size--;

    }


    public void deleteSecondLast() {
        //        Node temp = top;
        //
        //        if (temp != null && temp.getNext() != null) {
        //            Node secondtemp = temp.getNext();
        //            while (temp != null&&secondtemp!=null)
        //
        //            {
        //                if(secondtemp.getNext()==null)
        //                {
        //                    size--;
        //                    temp
        //                }
        //            }
        //
        //
        //        }


    }

    public void moveMin() {
        Node min, prevMin;
        Node curr, prev;


        if ((top != null) && (top.next != null)) {
            prevMin = null;
            ;
            min = top;
            prev = top;
            curr = top.getNext();
            while (curr != null) {
                if (curr.getData() < min.getData()) {
                    prevMin = prev;
                    min = curr;
                }
                prev = curr;
                curr = curr.getNext();
            }

            if (top != null) {
                prevMin.setNext(min.getNext());
                min.setNext(top);
                top = min;
            }

        }
    }

    public void deleteLast() {
        Node temp = top;

        if (top != null) {
            while (temp != null) {
                if (temp.getNext() == null) {
                    temp = null;
                    size--;
                    break;


                }
                temp = temp.getNext();
            }

        }


    }

    public void delete(int key) {

        Node prev = null;
        Node curr = top;
        while ((curr != null) && (curr.item != key)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            if (prev != null) {
                prev.next = curr.next;
                size--;
            } else {
                top = curr.next;
                size--;
            }
        }
    }

    public void copy(LINKED_List_ttesr newList) {
        Node curr = this.top;
        for (int i = 0; i < size; i++) {
            newList.insertUnordered(curr.getData());
            curr.getNext();


        }

    }
    // and other method


    private class Node {
        public int item;
        public Node next;

        public Node(int newitme, Node NExt) {
            item = newitme;
            next = NExt;
        }

        public int getData() {
            return item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextI) {
            next = nextI;
        }

        public String toString() {
            String S = "" + item;
            return S;
        }
    }
}
