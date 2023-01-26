import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    BinarySearchTree<Integer> binarySearchTree;
    @BeforeEach
    void setUp() {
        binarySearchTree = new BinarySearchTree();
    }

    @Test
    void insert() {
        binarySearchTree.insert(1);
        assertEquals(1, binarySearchTree.getSize(),"Tree's size should now be 1");
        assertEquals(true, binarySearchTree.search(1), "Tree should contain new value");
    }

    @Test
    @DisplayName("findMaximum should handle empty tree case")
    void findMaximumWhenEmptyTree() {
        assertEquals(null, binarySearchTree.findMaximum(), "findMaximum should handle empty tree case");
    }

    @Test
    @DisplayName("findMaximum should find maximum value")
    void findMaximum() {
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(9);
        binarySearchTree.insert(7);
        assertEquals(9, binarySearchTree.findMaximum(), "findMaximum should find maximum value");
    }

    @Test
    @DisplayName("findMinimum should handle empty tree case")
    void findMinimumWhenEmptyTree() {
        assertEquals(null, binarySearchTree.findMinimum(), "findMinimum should handle empty tree case");
    }

    @Test
    @DisplayName("findMinimum should find minimum value")
    void findMinimum() {
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(-3);
        binarySearchTree.insert(9);
        binarySearchTree.insert(7);
        assertEquals(-3, binarySearchTree.findMinimum(), "findMinimum should find minimum value");
    }

    @Test
    void breadthFirstTraversal() {
    }

    @Test
    void preOrderTraversal() {
    }

    @Test
    void inOrderTraversal() {
    }

    @Test
    @DisplayName("Searching for root value should work.")
    void searchForRoot() {
        binarySearchTree.insert(1);
        assertEquals(true, binarySearchTree.search(1), "Root value should be returned");
    }

    @Test
    @DisplayName("Searching for child value should work. (Includes leaf value)")
    void searchForChild() {
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(9);
        binarySearchTree.insert(7);
        assertEquals(true, binarySearchTree.search(7), "Child's value should be returned");
    }

    @Test
    @DisplayName("Search function should handle non-existent value larger than largest number in tree")
    void searchForNonExistentTooLarge() {
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(9);
        binarySearchTree.insert(7);
        assertEquals(false, binarySearchTree.search(11), "Search function should handle non-existent value");
    }
    
    @Test
    @DisplayName("Search function should handle non-existent value larger than largest number in tree")
    void searchForNonExistentTooSmall() {
        binarySearchTree.insert(1);
        binarySearchTree.insert(-4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(-9);
        binarySearchTree.insert(7);
        assertEquals(false, binarySearchTree.search(-11), "Search function should handle non-existent value");
    }

    @Test
    @DisplayName("findSuccessor should find successor when matching node has right child")
    void findSuccessorWhenRightChild() {
        binarySearchTree.insert(1);
        binarySearchTree.insert(-4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(-9);
        binarySearchTree.insert(8);
        binarySearchTree.insert(3);
        assertEquals(8,binarySearchTree.findSuccessor(7), "findSuccessor should find successor when matching node has right child");
    }

    @Test
    @DisplayName("findSuccessor should find successor when matching node has no right child")
    void findSuccessorWhenNoRightChild() {
        binarySearchTree.insert(1);
        binarySearchTree.insert(-4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(-9);
        binarySearchTree.insert(10);
        binarySearchTree.insert(8);
        binarySearchTree.insert(3);
        assertEquals(8,binarySearchTree.findSuccessor(7), "findSuccessor should find successor when matching node has right child");
    }
}