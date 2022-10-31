package E_Tree;


import java.util.ArrayList;

class BST_BESTVER {
    public static void main(String[] args) {
        BST data = new BST();
        //        data.insert(15);
        //        data.insert(10);
        //        data.insert(25);
        //        data.insert(8);
        //        data.insert(12);
        //        data.insert(20);
        //        data.insert(30);
        //        data.insert(6);
        //        data.insert(9);
        //        data.insert(18);
        //        data.insert(22);
        //        data.LCA(6, 12);
        int[] map = {40, 30, 70, 55, 50, 65};

        for (int i = 0; i < map.length; i++)
            data.insert(map[i]);

        System.out.println(data.inPrint());//inorder
        System.out.println(data.PrePrint());//pre
        System.out.println(data.PostPrint());//post

        System.out.println(data.successor(80));
        //        data.print();
        //        System.out.println(data.findSuccessor(50));
        //        System.out.println(data.Kbigest(1));

        //        data.Ksmaller(1);
        //        data.deleteOdd();
        // data.delete(60);
        data.print();
        //data.check_BST()

    }


}

class BST {

    private class Node {
        public int item;
        public Node left;
        public Node right;

        public Node(int i) { //makes a leaf
            item = i;
            left = right = null;
        }

        //***insert Node methods here***

    }//end class Node

    private Node root;

    public BST() {
        root = null;
    }

    public String inPrint() {
        return inorderTraversal(root);

    }//end inorderTraversal


    private String inorderTraversal(Node curr) {
        String S = "";

        if (curr != null) {


            S += inorderTraversal(curr.left);

            S += curr.item + " ";
            S += inorderTraversal(curr.right);


        }

        return S;
    }

    public String PrePrint() {
        return preorder(root);

    }//end inorderTraversal


    private String preorder(Node curr) {
        String S = "";

        if (curr != null) {

            S += curr.item + " ";
            S += preorder(curr.left);


            S += preorder(curr.right);


        }

        return S;
    }

    public void deleteoDD(Node root) {
        Node curr = root;

        if (curr != null) {
            if (curr.item % 2 == 1)
                delete(curr.item);
            deleteoDD(curr.left);
            deleteoDD(curr.right);


        }


    }

    public void deleodd() {
        deleteoDD(root);
    }


    public String PostPrint() {
        return postorder(root);

    }//end inorderTraversal


    private String postorder(Node curr) {
        String S = "";

        if (curr != null) {


            S += postorder(curr.left);


            S += postorder(curr.right);
            S += curr.item + " ";

        }

        return S;
    }


    ///////////end of privcate
    public void insert(int key) {
        root = insertRec(root, key);
    }//end insert

    private Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);

            return root;
        }


        if (key > root.item) {
            root.right = insertRec(root.right, key);

        } else if (key < root.item)
            root.left = insertRec(root.left, key);


        return root;
    }

    //////// test if the lab is right./////////
    private void easyDelete(Node del, Node delParent, Node delChild) {
        if (delParent != null) {
            if (del == delParent.left)
                delParent.left = delChild;
            else delParent.right = delChild;

        } else {
            root = delChild;

        }

    }

    private void twoChilDel(Node curr) {
        Node is = curr.right;
        Node isParent = curr;

        while (is.left != null) {
            isParent = is;
            is = is.left;
        }

        curr.item = is.item;
        easyDelete(is, isParent, is.right);


    }

    public void delete(int key) {
        Node curr = root;
        Node prev = null;
        while (curr != null && curr.item != key) {
            prev = curr;
            if (key < curr.item)
                curr = curr.left;
            else curr = curr.right;
            //System.out.println(curr.item);

        }

        if (curr != null) {
            //  System.out.println(curr.item);

            if (curr.left == null)
                easyDelete(curr, prev, curr.right);
            else if (curr.right == null) {
                easyDelete(curr, prev, curr.left);
            } else {
                twoChilDel(curr);

            }
        }
    }

    //***insert tree methods here***
    public void print() {
        printSpecial("", root, false);
    }

    public void printSpecial(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "L-- " : "R-- ") + n.item);
            printSpecial(prefix + (isLeft ? "|   " : "    "), n.left, true);
            printSpecial(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }


    /******
     *  Given a sorted array of number construc a BST
     * [1,2,3,4,5,6]
     *
     *               3
     *              / \
     *             2   5
     *            /    /\
     *           1   4      6
     *
     *
     *
     *
     *
     *
     */


    public Node recMiddle(int[] array, int from, int to) {

        if (from > to)
            return null;
        int middle = (from + to) / 2;


        Node result = new Node(array[middle]);
        result.left = recMiddle(array, from, middle - 1);
        result.right = recMiddle(array, middle + 1, to);


        return result;


    }


    /**********************************
     Range Sum of BST

     Return the sum of all value in BST
     https://leetcode.com/problems/range-sum-of-bst/
     **********************************/
    public int rangeSumBST(Node root, int low, int high) {

        int result = 0;

        if (root == null)
            return result;


        if (root.item >= low && root.item <= high)
            result += root.item;


        result += rangeSumBST(root.left, low, high);
        result += rangeSumBST(root.right, low, high);


        return result;

    }


    /**********************************
     897. Increasing Order Search Tree
     from a sorted array make the tree
     with only 1 deg
     **********************************/
    public void NodeTo_1degtree(Node root, int[] arr, int count) {

        if (count == arr.length)
            return;
        root.right = new Node(arr[count]);
        NodeTo_1degtree(root.right, arr, count + 1);
    }

    //    class Solution {
    //        //declare global tree - res
    //        static BST.Node res;
    //
    //        public static BST.Node increasingBST(BST.Node root) {
    //            if (root == null)
    //                return null;
    //            BST.Node curr = new BST.Node(0);
    //            //res is initialized
    //            res = curr;
    //            //here curr will work as a pointer to the root node later
    //            recur(root);
    //            return curr.right;
    //        }
    //
    //        public static void recur(BST.Node root) {
    //            if (root == null)
    //                return;
    //            recur(root.left);
    //            res.right = new BST.Node(root.item);
    //            res = res.right;
    //            recur(root.right);
    //        }


    //orther solution


    /****************
     from a tree to BST
     */

    //    static class treeToBST {
    //
    //        static int count;
    //
    //        /********************************
    //         this will take an array then ( ordered array)
    //         then make it into a BST
    //         ********************************************/
    //        public void ArraytoBST(Node root, int[] arr1) {
    //            if (root == null)
    //                return;
    //
    //            ArraytoBST(root.left, arr1);
    //            root.item = arr1[count++];
    //            ArraytoBST(root.right, arr1);
    //        }
    //
    //        /********************************
    //         from Node root and empty array make array of all the Node
    //         ********************************************/
    //
    //
    //        public static void makearray(Node root, int[] arr1) {
    //            if (root == null)
    //                return;
    //
    //
    //            makearray(root.left, arr1);
    //            arr1[count++] = root.item;
    //
    //            makearray(root.right, arr1);
    //
    //        }
    //
    //        /********************************
    //         count total node in the tree
    //         ********************************************/
    //        public static int countARR(Node root) {
    //            int result = 1;
    //            if (root == null)
    //                return 0;
    //
    //
    //            result += countARR(root.left);
    //
    //
    //            result += countARR(root.right);
    //
    //            return result;
    //        }
    //
    //
    //    }


    /*******************
     *
     * CHECK IF THE TREE IS BST OR NOT
     *
     *
     *
     *
     *
     */

    public boolean check() {
        return check_BST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean check_BST(Node root, int min, int max) {
        if (root == null)

            return true;
        if (root.item < min || root.item > max)
            return false;

        return check_BST(root.left, min, root.item) && check_BST(root.right, root.item, max);


    }


    /*******************
     *
     * Find the Lowest Common Ancestor (LCA) of two nodes in a BST
     *
     *
     *
     *
     *
     */


    public void LCA(int num1, int num2) {
        int result = -1;
        ArrayList<Integer> Fnum1 = new ArrayList<Integer>(); // Create an ArrayList object
        ArrayList<Integer> Fnum2 = new ArrayList<Integer>(); // Create an ArrayList object
        fill_array(root, num1, Fnum1);
        fill_array(root, num2, Fnum2);

        for (int i = 0; i < Fnum1.size() && i < Fnum2.size(); i++)
            if (Fnum2.get(i) == Fnum1.get(i))
                result = Fnum1.get(i);

        for (int number : Fnum1) {
            System.out.print(number + " ");
        }
        System.out.println();

        for (int number : Fnum2) {
            System.out.print(number + " ");
        }
    }


    public void fill_array(Node root, int num, ArrayList<Integer> data) {
        if (root == null || root.item == num)
            return;

        if (num < root.item)
            fill_array(root.left, num, data);
        data.add(root.item);
        if (num > root.item)
            fill_array(root.right, num, data);
    }

    //////////////////////////////Solution.........................
    //    public static Node LCARecursive(Node root, int x, int y)
    //    {
    //        // base case: empty tree
    //        if (root == null) {
    //            return null;
    //        }
    //
    //        // if both `x` and `y` is smaller than the root, LCA exists in the
    //        // left subtree
    //        if (root.data > Integer.max(x, y)) {
    //            return LCARecursive(root.left, x, y);
    //        }
    //
    //        // if both `x` and `y` are greater than the root, LCA exists in the
    //        // right subtree
    //        else if (root.data < Integer.min(x, y)) {
    //            return LCARecursive(root.right, x, y);
    //        }
    //
    //        // if one key is greater (or equal) than the root and one key is
    //        // smaller (or equal) than the root, then the current node is LCA
    //        return root;
    //    }
    //
    //    // Print lowest common ancestor of two nodes in the BST
    //    public static void LCA(Node root, int x, int y)
    //    {
    //        // return if the tree is empty or `x` or `y` is not present
    //        // in the tree
    //        if (root == null || !search(root, x) || !search(root, y)) {
    //            return;
    //        }
    //
    //        // `lca` stores the lowest common ancestor of `x` and `y`
    //        Node lca = LCARecursive(root, x, y);
    //
    //        // if the lowest common ancestor exists, print it
    //        if (lca != null) {
    //            System.out.println("LCA is " + lca.data);
    //        }
    //        else {
    //            System.out.println("LCA does not exist");
    //        }
    //    }


    //////////////////////Minimum element in BST

    public int minValue() {
        return minValue(root);
    }

    public int minValue(Node node) {

        if (node == null)
            return Integer.MAX_VALUE;


        int res = node.item;
        int lres = minValue(node.left);
        int rres = minValue(node.right);

        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;
    }


    ///////////////////////////////// Normal BST to balanced/////


    public BST buildBalanced(Node root) {
        ArrayList<Integer> resutlarr = new ArrayList<Integer>();
        balanced(root, resutlarr);


        BST result = new BST();

        for (int i = 1; i < resutlarr.size(); i++)
            result.insert(resutlarr.get(i));


        return result;
    }


    public void balanced(Node root, ArrayList<Integer> resutl) {

        if (root != null) {


            inorderTraversal(root.left);

            resutl.add(root.item);
            inorderTraversal(root.right);


        }


    }

    ///////////////find klargest////////////
    public int totalNode() {
        return totalNode(root);
    }

    public int totalNode(Node root) {
        int result = 0;
        if (root != null) {

            result += totalNode(root.left);

            result += totalNode(root.right);
            result += 1;
        }
        return result;
    }
    //
    //   3.2) Else, here we have 2 cases:
    //    a) Find the inorder successor of current Node.
    //    Inorder successor is the left most Node
    //    in the right subtree or right child itself.
    //    b) If the left child of the inorder successor is NULL:
    //            1) Set current as the left child of its inorder
    //    successor.
    //      2) Move current Node to its right.
    //    c) Else, if the threaded link between the current Node
    //    and it's inorder successor already exists :
    //            1) Set left pointer of the inorder successor as NULL.
    //      2) Increment count and check if count is equal to K.
    //            a) If count is equal to K, simply return current
    //    Node as it is the Kth largest Node.


    public int Kbigest(int k) {
        return KSamlest(k, root).item;

    }

    public Node KSamlest(int k, Node root) {
        Node curr = root;
        int count = 0;
        Node Klargest = null;

        while (curr != null) {
            if (curr.right == null) {
                count++;
                if (count == k)
                    Klargest = curr;
                else curr = curr.left;
            } else {
                Node suc = curr.right;
                while (suc.left != null && suc.left != curr) {
                    suc = suc.left;
                }

                if (suc.left == null) {
                    suc.left = curr;
                    curr = curr.right;
                } else {
                    suc.left = null;
                    count++;
                    if (count == k)
                        Klargest = curr;
                    curr = curr.left;

                }
            }


        }
        return Klargest;
    }


    ///////// find inordersuccesor/////

    public Node getNode(Node root, int key) {
        Node result = null;
        if (root != null) {
            if (root.item == key)
                return result = root;

            if (root.item < key)
                result = getNode(root.left, key);
            else result = getNode(root.right, key);


        }
        return result;
    }



    public int successor(int key) {
        if( successor(root, null, key)==Integer.MIN_VALUE)
            System.out.println("NOt exist");
        return successor(root, null, key);
    }

    public int successor(Node root, Node succ, int key) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.item == key) {
            if (root.right != null) {
                Node temp=root.right;
                while(temp.left!=null)
                    temp=temp.left;
                return temp.item;
            }
        } else if (key < root.item) {

            succ = root;
            // System.out.println(succ.item);
            if (successor(root.left, succ, key) == Integer.MIN_VALUE)
                return succ.item;
            else return successor(root.left, succ, key);
        } else if (key > root.item){
            return successor(root.right, succ, key);
        }

        return succ.item;
    }

    //////////////////////////////delete odd///////////////


    public void deleteOdd() {


        removeOdds(root);

    }

    private void removeOdds(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        //found odd
        if (currentNode.item % 2 != 0) {
            delete(currentNode.item);
        }
        removeOdds(currentNode.left);
        removeOdds(currentNode.right);
    }
    //
    //    public void removeOddSubstrees(Node root) {
    //        if (root.left != null) {
    //            if (root.left.item % 2 != 0) {
    //                root.left = null;
    //            }
    //            else {
    //                removeOddSubstrees(root.left);
    //            }
    //        }
    //
    //        if (root.right != null) {
    //            if (root.right.item % 2 != 0) {
    //                root.right = null;
    //            }
    //            else {
    //                removeOddSubstrees(root.right);
    //            }
    //        }
    //    }


    //////////////find k smallest........

    public int Ksmaller(int key) {
        int[] data = new int[totalNode(root)];
        extractValues(root, data, 0);
        System.out.println(data[key - 1]);
        return data[key - 1];
    }

    public int BSTtoArray(Node root, int[] arr, int position) {


        if (root != null) {

            position = BSTtoArray(root.left, arr, position);
            arr[position++] = root.item;

            position = BSTtoArray(root.right, arr, position);
        }

        return position;

    }

    private int extractValues(Node n, int[] results, int index) {
        if (n.left != null) {
            index = extractValues(n.left, results, index);
        }

        if (n.right != null) {
            index = extractValues(n.right, results, index);
        }

        results[index] = n.item;

        return index + 1;
    }
    /////////////////////////////////test 3

    public int hashCode1(String key, int size) {
        int result = 0;
        for (int j = 0; j < key.length(); j++) {

            int letter = key.charAt(j) - 'a';
            result = (result * 3 + letter) % size;
        }
        return result;
    }


    ///Add all greater values to every node in a BST


    public void makeSum(Node root, int sum) {
        if (root != null) {
            makeSum(root.right, sum);

            sum += root.item;
            root.item = sum;
            makeSum(root.left, sum);


        }
    }

    public void makeSum() {
        makeSum(root, 0);
    }

    // find the closet element bst

    public int Closet(int k) {
        return Closet(root, k);
    }

    public int Closet(Node root, int k) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.item == k)
            return -1;
        if (root.item < k)
            return Math.min(Math.abs(root.item - k), Closet(root.right, k));


        return Math.min(Math.abs(root.item - k), Closet(root.left, k));

    }
}

//class solution
//{
//    Node root;
//    public printBreadthFirst(){
//        //Complete this method.
//        //It should print the Nodes in the tree, level-by-level, to the console.
//        String S="";
//        Queue data= new Queue();
//        data.push(root);
//        while(!data.isEmpty())
//        {
//            Node temp= data.pop();
//            S+=temo.data;
//
//            if(temp.left!=null)
//                data.push(temp.left);
//            if(temp.right!=null)
//                data.push(temp.right);
//
//
//
//        }
//        System.out.println( S);
//    }
//}
//end class BST
