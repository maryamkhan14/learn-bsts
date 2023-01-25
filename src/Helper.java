// TODO: alter this to only those utilities you need
import java.util.*;

public class Helper {

    // declare tree
    private BinarySearchTree tree;

    // declare and initialize options hashmap
    // TODO: Is it bad to declare & initialize at the same time?
    private static HashMap<Integer,String> OPTIONS = new HashMap<>(
            Map.of(
                    0, "Exit program",
                    1, "Create a new binary tree!",
                    2, "Insert a value in your tree.",
                    3, "Find the maximum value in your binary tree.",
                    4, "Find the minimum value in your binary tree.",
                    5, "Perform a breadth first traversal.",
                    6, "Perform a pre-order traversal."
            )
    );

    /**
     * Constructor for Helper class
     */
    public Helper() {
        // initialize tree
        this.tree = new BinarySearchTree<>();
    }

    /**
     * Handle user input
     * @param input The user's input
     */
    private void handleResponse(String input) {
        // TODO: Implement better error handling (modularize)
        int option;
        try {
            option = Integer.parseInt(input);
        }
        catch (Exception e) {
            System.out.println("Your input wasn't a number. Please try again.");
            presentOptions();
            return;
        }
        switch (option) {
            case 1:
                createNew();
                presentOptions();
                break;
            case 2:
                insert();
                presentOptions();
                break;
            case 3:
               findMaximum();
               presentOptions();
               break;
            case 4:
                System.out.println("To be implemented...");
                break;
            case 5:
                breadthFirstTraversal();
                presentOptions();
                break;
            case 6:
                preOrderTraversal();
                presentOptions();
                break;
            case 0:
                // TODO: Put exit message in exit method to be consistent
                break;
            default:
                System.out.println("Your chosen option isn't on the list. Please try again!");
                presentOptions();
                break;
        }
    }

    /**
     * Creates new binary tree.
     */
    private void createNew() {
        System.out.println("Creating new tree...");
        tree = new BinarySearchTree();
        System.out.println("New empty tree created!");
    }

    /**
     * Gets the list of nodes' values to be inserted into the tree.
     * @return List of integers inputted by user.
     */
    private ArrayList<Integer> getNodeValues() {
        // initialize list of integers, and input string
        ArrayList<Integer> ints = new ArrayList<>();
        String value = "";


        System.out.println("Please enter integer values. When you are done, enter '---' (three dashes.)");

        Scanner sc = new Scanner(System.in);
        // Keep running until user enters exit prompt
        while(true) {
            value = sc.nextLine();

            if (value.equals("---")) {
                break;
            }

            try {
                ints.add(Integer.parseInt(value));
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                break;
            }
        }
        return ints;
    }

    /**
     * Inserts list of node values into tree
     */
    private void insert() {
        // invoke BinarySearchTree's insert method on tree
        for (Integer integer : getNodeValues()) {
            tree.insert(integer);
        }
        // Success message
        System.out.println("All valid values were inserted! Perform a traversal to see the results.");
    }

    /**
     * Reports maximum value of tree
     */
    private void findMaximum() {
        // check for empty tree
        if (tree.getSize() == 0) {
            System.out.println("The binary tree is empty. Please insert some numbers, then try the command prompt again.");
        } else {
            System.out.println("The maximum value is " + tree.findMaximum());
        }
    }

    //TODO: Remove repetition from traversals
    /**
     * Invokes breadthFirstTraversal method on current tree
     */
    private void breadthFirstTraversal() {
        // check for empty tree
        if (tree.getSize() == 0) {
            System.out.println("The binary tree is empty. Please insert some numbers, then try the command prompt again.");
        }
        else {
            System.out.println("Starting breadth-first traversal. ");
            tree.breadthFirstTraversal();
            System.out.println("\n" + "Traversal complete!");
        }
    }

    private void preOrderTraversal() {
        if (tree.getSize() == 0) {
            System.out.println("The binary tree is empty. Please insert some numbers, then try the command prompt again.");
        }
        else {
            System.out.println("Starting pre-order traversal. ");
            tree.preOrderTraversal();
            System.out.println("\n" + "Traversal complete!");
        }
    }
    /**
     * Constructs options list
     * @return optionsMessage The list of options.
     */
    private String constructOptions() {
        String optionsMessage = "";
        optionsMessage += "\n\n" + "-------------------------------------------------" + "\n\n";
        for (Integer optionKey : OPTIONS.keySet()) {
            optionsMessage += optionKey + ": " + OPTIONS.get(optionKey) + "\n";
        }

        return optionsMessage;
    }

    /**
     * Presents list of options using constructed message
     */
    private void presentOptions() {
        System.out.println(constructOptions());
    }

    /**
     * Reads user's selected option until user enters three dashes to exit.
     */
    private void getOption() {
        String option = "";

        Scanner sc = new Scanner(System.in);
        // Keep running until user enters exit prompt
        while(true) {
            if (option.equals(0)) {
                break;
            }
            option = sc.nextLine();
            handleResponse(option);
        }
    }

    /**
     * Greets user and presents options list
     */
    public void greet() {
        System.out.println("Welcome to our Binary Search Tree tutorial! Please pick an option below to get started.");
        presentOptions();
        getOption();
        System.out.println("Thanks for stopping by!");
    }
}
