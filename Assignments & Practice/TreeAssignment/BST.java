package TreeAssignment;

import java.util.*;

class BinarySearchTree <T extends Comparable<T>> {
    class Node<T> {
        Node<T> left;
        Node<T> right;
        T data;

        Node(Node<T> left, Node<T> right, T data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    // instance variables
    Node<T> root;

    // method to insert elements into the BST
    public void insert(T data) {
        Node<T> newNode = new Node<>(null, null, data);
        if (root == null) {
            root = newNode;
            System.out.println("Successful Insertion of root node !");
        }
        // if there is already a root node then we search for the node and insert
        else {
            Node<T> p = root;
            Node<T> parent = null;
            while (p != null) {
                parent = p;

                // compare the newNode's value to every node
                if (data.compareTo(p.data) > 0) {
                    p = p.right;
                } else if (data.compareTo(p.data) < 0) {
                    p = p.left;
                } else {
                    System.out.println("The tree already contains the value " + data);
                    return;
                }
            }

            // finally insert the values here
            boolean value = data.compareTo(parent.data) > 0;
            if (value)
                parent.right = newNode;
            else
                parent.left = newNode;

            System.out.println("Successful-Insertion");
        }
    }

    // recursive method to insert nodes in the bst
    public Node <T> insert(Node <T> p, T data){
        // base case is when the p is null just return the newNode
        if (p==null)
            return new Node <T> (null, null, data);

        if (data.compareTo(p.data) > 0) {
            p.right = insert(p.right, data);
        }
        else if (data.compareTo(p.data) < 0) {
            p.left = insert(p.left, data);
        }

        // for any other case return the node that was sent
        return p;
    }

    // method to perform deletion of an element in bst
    public Node <T> delete(Node <T> p, T data) {
        if (p==null)
            return null;

        if (data.compareTo(p.data) > 0) {
            p.right = delete(p.right, data);
        }
        else if (data.compareTo(p.data) < 0) {
            p.left = delete(p.left, data);
        }
        else {
            // this is when the data matches with the node's data

            // now we need to check if the node has either left or right child
            if (p.left == null) {
                return p.right;
            }

            if (p.right == null) {
                return p.left;
            }

            // if the node to be deleted is internal node
            Node <T> successor = findSuccessor(p.right);
            p.data = successor.data;
            p.right = delete(p.right, successor.data);
        }

        return p;
    }


    // method to find and return inorder successor
    public Node <T> findSuccessor(Node <T> p) {
        while (p != null && p.left != null) {
            p = p.left;
        }
        return p;
    }

    // methods to find the inorder, preorder and postorder of the tree
    public void inorder(Node <T> p) {
        if (p == null) {
            return;
        }

        inorder(p.left);
        System.out.print(p.data + " ");
        inorder(p.right);
    }

    public void preorder(Node <T> p) {
        if (p == null) {
            return;
        }

        System.out.print(p.data + " ");
        preorder(p.left);
        preorder(p.right);
    }

    public void postorder(Node <T> p) {
        if (p == null) {
            return;
        }

        postorder(p.left);
        postorder(p.right);
        System.out.print(p.data + " ");
    }

    // method to find a node by the value
    public boolean findNode(T val) {
        if (root == null) {
            return false;
        }
        else {
            Node <T> p = root;
            while (p!=null) {
                // now check and compare val with every nodes
                if (val.compareTo(p.data) < 0) {
                    p = p.left;
                }
                else if (val.compareTo(p.data) > 0) {
                    p = p.right;
                }
                else {
                    return true;
                }
            }
        }

        // for every other case we return false
        return false;
    }

    // method to find count of total nodes
    public int countNodes(Node <T> root) {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    // method to find the levelorder traversal of the bst
    public List <List<T>> levelorder(Node <T> p) {
        // if the p is empty return an empty linked list
        if (p == null)
            return new ArrayList <> ();

        Queue <Node <T>> q = new LinkedList <> ();
        List <List<T>> res = new ArrayList <> ();

        q.offer(p);
        int currentLevel = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            res.add(new ArrayList<T>());

            for (int i=0; i<len; i++) {
                Node <T> cur = q.poll();
                res.get(currentLevel).add(cur.data);

                if (cur.left != null)
                    q.offer(cur.left);

                if (cur.right != null)
                    q.offer(cur.right);
            }

            currentLevel++;
        }

        return res;
    }

    // method to find the height of the tree
    public int findHeight(Node <T> root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // method to count the leaf nodes
    public int countLeaves(Node <T> root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            return 1;
        }

        int countLeft = countLeaves(root.left);
        int countRight = countLeaves(root.right);
        return countLeft + countRight;
    }
}

public class BST {
    public static void main (String[] args) {
        BinarySearchTree <Integer> bst = new BinarySearchTree <> ();
        bst.insert(20);
        bst.insert(39);
        bst.insert(9);
        bst.insert(23);
        System.out.println();
        bst.inorder(bst.root);
        System.out.println();
        bst.preorder(bst.root);
        System.out.println();
        bst.postorder(bst.root);

        // making another tree just to test the recursive insert method
        BinarySearchTree <Integer> bst2 = new BinarySearchTree <> ();
        bst2.root = bst2.insert(bst2.root, 929);
        bst2.root = bst2.insert(bst2.root, 92);
        bst2.root = bst2.insert(bst2.root, 73);
        bst2.root = bst2.insert(bst2.root, 73);
        bst2.root = bst2.insert(bst2.root, 52);
        System.out.println("BST inorder : ");
        bst2.inorder(bst2.root);
        System.out.println();
        bst2.preorder(bst2.root);
        System.out.println();
        bst2.postorder(bst2.root);
        System.out.println();
        bst2.root = bst2.delete(bst2.root, 929);
        bst2.inorder(bst2.root);
        System.out.println();
        
        List <List<Integer>> res = bst.levelorder(bst.root);
        System.out.println(res);
        System.out.println(bst.findNode(9));
        System.out.println(bst.countNodes(bst.root));
        System.out.println(bst.findHeight(bst.root));
        System.out.println(bst.countLeaves(bst.root));
        System.out.println(bst.countLeaves(bst.root));
    }
}
