// TODO: alter this to only those utilities you need
import java.util.*;

public class Helper {

    // declare tree
    private BinarySearchTree tree;

    // declare and initialize options hashmap
    // TODO: Is it bad to declare & initialize at the same time?
    private static HashMap<Integer,String> OPTIONS = new HashMap<>(
            Map.ofEntries(
                    new AbstractMap.SimpleEntry<>(0, "Exit program"),
                    new AbstractMap.SimpleEntry<>(1, "Create a new binary tree!"),
                    new AbstractMap.SimpleEntry<>(2, "Insert a value in your tree."),
                    new AbstractMap.SimpleEntry<>(3, "Find a value in your binary tree."),
                    new AbstractMap.SimpleEntry<>(4, "Find the maximum value in your binary tree."),
                    new AbstractMap.SimpleEntry<>(5, "Find the minimum value in your binary tree."),
                    new AbstractMap.SimpleEntry<>(6, "Perform a breadth first traversal."),
                    new AbstractMap.SimpleEntry<>(7, "Perform a pre-order traversal."),
                    new AbstractMap.SimpleEntry<>(8, "Perform an in-order traversal."),
                    new AbstractMap.SimpleEntry<>(9, "Find a node's successor"),
                    new AbstractMap.SimpleEntry<>(10, "Remove a node")
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
     * @param option The user's input
     */
    public void handleResponse(Integer option) {
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
                search();
                presentOptions();
                break;

            case 4:
                findMaximum();
                presentOptions();
                break;
            case 5:
                System.out.println("To be implemented...");
                presentOptions();
                break;
            case 6:
                breadthFirstTraversal();
                presentOptions();
                break;
            case 7:
                preOrderTraversal();
                presentOptions();
                break;
            case 8:
                inOrderTraversal();
                presentOptions();
                break;
            case 9:
                System.out.println("To be implemented...");
                presentOptions();
                break;
            case 10:
                System.out.println("To be implemented...");
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
    public void createNew() {
        System.out.println("Creating new tree...");
        tree = new BinarySearchTree();
        System.out.println("New empty tree created!");
    }

    /**
     * Gets the list of nodes' values to be inserted into the tree.
     * @return List of integers inputted by user.
     */
    public ArrayList<Integer> getNodeValues() {
        // initialize list of integers, and input string
        ArrayList<Integer> ints = new ArrayList<>();
        String value;


        System.out.println("Please enter integer values. When you are done, enter '---' (three dashes.)");

        Scanner sc = new Scanner(System.in);
        // Keep running until user enters exit prompt
        while(true) {
            value = sc.nextLine();

            if (value.equals("---")) {
                break;
            }

            if(validateInput(value)) {
                ints.add(Integer.parseInt(value));
            }
        }
        return ints;
    }

    /**
     * Inserts list of node values into tree
     */
    public void insert() {
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
    public void findMaximum() {
        // check for empty tree
        if (tree.getSize() == 0) {
            System.out.println("The binary tree is empty. Please insert some numbers, then try the command prompt again.");
        } else {
            System.out.println("The maximum value is " + tree.findMaximum() + ".");
        }
    }

    //TODO: Remove repetition from traversals
    /**
     * Invokes breadthFirstTraversal method on current tree
     */
    public void breadthFirstTraversal() {
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

    public void preOrderTraversal() {
        if (tree.getSize() == 0) {
            System.out.println("The binary tree is empty. Please insert some numbers, then try the command prompt again.");
        }
        else {
            System.out.println("Starting pre-order traversal. ");
            tree.preOrderTraversal();
            System.out.println("\n" + "Traversal complete!");
        }
    }

    public void inOrderTraversal() {
        if (tree.getSize() == 0) {
            System.out.println("The binary tree is empty. Please insert some numbers, then try the command prompt again.");
        }
        else {
            System.out.println("Starting in-order traversal. ");
            tree.inOrderTraversal();
            System.out.println("\n" + "Traversal complete!");
        }
    }
    /**
     * Searches tree
     */
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the value you wish to search for");
        String searchValue = sc.nextLine();
        if (validateInput(searchValue)) {
            tree.search(convertInput(searchValue));
        }
    }
    /**
     * Constructs options list
     * @return optionsMessage The list of options.
     */
    public String constructOptions() {
        String optionsMessage = "";
        optionsMessage += "-------------------------------------------------" + "\n\n";
        for (Integer optionKey : OPTIONS.keySet()) {
            optionsMessage += optionKey + ": " + OPTIONS.get(optionKey) + "\n";
        }

        return optionsMessage;
    }

    /**
     * Presents list of options using constructed message
     */
    public void presentOptions() {
        System.out.println(constructOptions());
    }

    /**
     * Validates input string
     * @param input The input user entered
     * @return True if the input can be converted to integer, False if not
     */
    private boolean validateInput(String input) {
        try {
            int option = Integer.parseInt(input);
        }
        catch (Exception e) {
            System.out.println("Your input wasn't a number. Please try again.");
            return false;
        }
        return true;
    }

    /**
     * Converts input to integer value if it is a valid integer value
     * @param input The input the user entered
     * @return the integer value of the input, or -1 if the input is an invalid integer value
     */
    public int convertInput(String input) {
        if (validateInput(input)) return Integer.parseInt(input);
        return -1;
    }

    /**
     * Reads user's selected option until user enters three dashes to exit.
     */
    public void getOption() {
        String option; // initialize to any string version of integer value other than 0

        Scanner sc = new Scanner(System.in);
        // Keep running until user enters exit prompt
        while(true) {
            option = sc.nextLine();
            if (validateInput(option)) {
                if (convertInput(option) == 0) {
                    break;
                }
                handleResponse(convertInput(option));
            }
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
