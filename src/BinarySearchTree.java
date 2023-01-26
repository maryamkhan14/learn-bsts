import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable> {
    // initialize root node
    private Node<T> root;
    int size;
    /**
     * Represents a tree.
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Gets the tree's size
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the tree's size
     * @param size The size of the tree
     */
    public void setSize(int size) {
        this.size = size;
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
     * Inserts a node into the tree using data to be added.
     * @param data The node's data.
     */
    public void insert(T data) {
        insert(root, data, 1);
    }

    private Node<T> insert(Node<T> node, T data, Integer height) {
        // Create root node if tree is empty
        if (root == null) {
            root = new Node<>(data, height);
            setSize(1);
            return root;
        }

        // Base case: return new node if node is null (no more right children or left children)
        if (node == null) {
            return new Node<>(data, height);
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
        setSize(getSize() + 1);
        return node;
    }


    /**
     * Finds minimum value present in tree given a node
     * @return The minimum value in the tree.
     */
    public T findMinimum() {
        return findMinimum(root);
    }

    private T findMinimum(Node<T> node) {
        if (node == null) {
            System.out.println("The binary tree is empty. Terminating search.");
            return null;
        }
        // Base case: return data if no more right children
        if(node.left == null) {
            System.out.print("No more left children exist. ");
            return node.data;
        }
        System.out.println("Found node with value " + node.data + ". Searching left.");
        // Keep checking right children
        return findMinimum(node.left);
    }

    /**
     * Finds maximum value present in tree
     * @return The maximum value in the tree.
     */
    public T findMaximum() {
        return findMaximum(root);
    }
    private T findMaximum(Node<T> node) {
        if (node == null) {
            System.out.println("The binary tree is empty. Terminating search.");
            return null;
        }
        // Base case: return data if no more right children
        if(node.right == null) {
            System.out.print("No more right children exist. ");
            return node.data;
        }
        System.out.println("Found node with value " + node.data + ". Searching right.");
        // Keep checking right children
        return findMaximum(node.right);
    }

    /**
     * Completes breadth first traversal
     */
    public void breadthFirstTraversal() {
        breadthFirstTraversal(root);
    }
    private void breadthFirstTraversal(Node<T> node) {
        // initialize queue for nodes to be stored
        Queue<Node<T>> nodesQueue = new LinkedList<>();

        // initialize prev pointer, which keeps track of previous node viewed
        Node<T> prev = null;

        // place root in queue
        nodesQueue.offer(node);

        while (!nodesQueue.isEmpty()) {
            // obtain first element in queue
            Node<T> newNode = nodesQueue.poll();

            // check for start of list
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

            // continue placing nodes in queue if left/right children exist
            if (newNode.left != null) nodesQueue.offer(newNode.left);
            if (newNode.right != null) nodesQueue.offer(newNode.right);

            // now that new node has been viewed, assign it to prev
            prev = newNode;
        }
    }

    /**
     * Demonstrates pre-order traversal of tree.
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }
    private void preOrderTraversal(Node<T> node) {
        // Base case: if current node is null
        if (node == null) {
            System.out.print("null. Going back." + "\n\n");
            return;
        }

        if(node == root) {
            System.out.println(node.data + ": root");
        } else {
            System.out.print(node.data + "\n\n");
        }

        System.out.print("Going left of " + node.data + ". Left child is ");
        preOrderTraversal(node.left);
        System.out.print("Going right of " + node.data + ". Right child is ");
        preOrderTraversal(node.right);
        System.out.print("Done assessing all of " + node.data + "'s children. Going back up." + "\n\n");
    }

    /**
     * Demonstrates in-order traversal of tree
     */
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node<T> node) {
        // Base case: if current node is null
        if (node == null) {
            System.out.print("No children found. Going back up." + "\n");
            return;
        }

        System.out.println("\n------------------\n" + "Child found. Searching left. ");
        inOrderTraversal(node.left);    // recursively search left children
        System.out.print("Node is " + node.data + ". Searching right. ");
        inOrderTraversal(node.right);   // recursively search right children
        System.out.print("Done assessing all of " + node.data + "'s descendants. Going back up." + "\n-----------------\n");
    }

    /**
     * Searches for data
     * @param data The value to be searched for
     * @return True if node with value exists, false if not
     */
    public boolean search(T data) {
        System.out.println("Starting search for " + data + ".");
        if(search(root, data) == null) {
            return false;
        }
        return true;
    }
    private T search(Node<T> node, T data) {
        if (node == null) {
            System.out.println("No node with the value " + data + " exists. Terminating search.");
            return null;
        }
        if (node.data == data) {
            System.out.println("Found node with value " + data + "! Terminating search.");
            return node.data;
        }
        System.out.print("Found " + node.data + ". ");
        if (data.compareTo(node.data) > 0) {
            System.out.println(data + " is bigger. Searching right.");
            data = search(node.right, data);
        } else if (data.compareTo(node.data) < 0) {
            System.out.println(data + " is smaller. Searching left.");
            data = search(node.left, data);
        }
        return data;
    }

    public T findSuccessor(T data) {
        return findSuccessor(root, data);
    }
    private T findSuccessor(Node<T> node, T data) {
        if (data.compareTo(node.data) == 0) {
            return findMinimum(node.right);
        }
        data = findSuccessor(node.right, data);
        return data;
    }
}
