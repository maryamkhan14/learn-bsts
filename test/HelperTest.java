import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    Helper helper;
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @BeforeEach
    void setUp() {
        helper = new Helper();
        helper.createNew();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test
    void handleResponse() {
    }

    @Test
    void createNew() {
    }

    @Test
    void getNodeValues() {
    }

    @Test
    void insert() {
    }

    @Test
    void findMaximum() {
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
    void constructOptions() {
    }

    @Test
    void presentOptions() {
    }

    @Test
    void convertInput() {
    }

    @Test
    void getOption() {
    }

    @Test
    void greet() {
    }


}