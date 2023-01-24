import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable> {
    // initialize root node
    Node<T> root;

    /**
     * Represents a tree.
     */
    public BinarySearchTree() {
        this.root = null;
    }
    /**
     * Represents a node.
     * @param <T> generic datatype
     */
    public class Node<T> {
        T data;
        Node<T> right;
        Node<T> left;

        int height;

        /**
         * Constructor for Node class
         * @param data The node's data.
         * @param height The node's height.
         */
        public Node(T data, int height) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = height;
        }
    }

    /**
     * Inserts a node into the tree.
     * @param data The node's data.
     */
    public void insert(T data) {
        insert(root, data, 1);
    }

    private Node<T> insert(Node<T> node, T data, Integer height) {
        // Create root node if tree is empty
        if (root == null) {
            root = new Node<T>(data, height);
            return root;
        }

        // Base case: return new node if node is null (no more right children or left children)
        if (node == null) {
            return new Node<T>(data, height);
        }

        if (data.compareTo(node.data) > 0) {
            // Keep searching right and incrementing height if inserted data > current node's data
            // Set node's right child to return value of function
            node.right = insert(node.right, data, height + 1);
        }
        else if (data.compareTo(node.data) < 0) {
            // Keep searching left and incrementing height if inserted data <>> current node's data
            // Set node's left child to return value of function
            node.left = insert(node.left, data, height + 1);
        }

        return node;
    }

    /**
     * Finds maximum value present in tree
     * @return The maximum value in the tree.
     */
    public T findMaximum() {
        return findMaximum(root);
    }
    private T findMaximum(Node<T> node) {
        // Base case: return data if no more right children
        if(node.right == null) {
            return node.data;
        }
        // Keep checking right children
        return findMaximum(node.right);
    }

    public void breadthFirstTraversal() {
        // TODO: replace with flag treeExists, treePopulated in Program
        if (root == null) {
            System.out.println("The binary tree is empty. Please insert some numbers, then try the command prompt again.");
        } else {
            breadthFirstTraversal(root);
        }
    }
    private void breadthFirstTraversal(Node<T> node) {
        Queue<Node<T>> nodesQueue = new LinkedList<>();
        nodesQueue.offer(root);
        Node<T> prev = null;

        System.out.println("Starting breadth-first traversal. ");
        while (!nodesQueue.isEmpty()) {
            Node<T> newNode = nodesQueue.poll();
            if(prev == null) {
                System.out.print("Root is: " + newNode.data);
            }
            else if(prev.height != newNode.height) {
                System.out.println("\n\n" + "Scanning level " + newNode.height + ".");
                System.out.print("Found: "+ newNode.data + " ");
            }
            else {
                System.out.print(newNode.data + " ");
            }

            if (newNode.left != null) nodesQueue.offer(newNode.left);
            if (newNode.right != null) nodesQueue.offer(newNode.right);
            prev = newNode;
        }
    }

}
