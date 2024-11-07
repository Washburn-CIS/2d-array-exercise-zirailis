import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests for CM111 TicTacToe Project
 * @author  Joseph Kendall-Morwick <Joseph.Kendall-Morwick@washburn.edu>
 */
public class TicTacToeTest
{
    
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        
    /**
     * Default constructor for test class A3Test
     */
    public TicTacToeTest()
    {
    }
    
    public static String normalizeSpace(String s) {
        return s.trim().replaceAll("\\s+", " ");
    }

    
    public void mainIOTest(String input, String output) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        TicTacToe.main(new String[]{ });
        input = normalizeSpace(input);
        var actualOutput = outContent.toString();
        if(!normalizeSpace(actualOutput).endsWith(normalizeSpace(output))) 
            fail("When presented with inputs '"+input+
            "', it was expected that output would end with '"+output+
            "'. Instead, full output was: '" + actualOutput+"'");
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {    
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }


    
    @Test
    public void checkpoint7Test1()
    {
        mainIOTest( "2\n2\n1\n1\n3\n3\n1\n3\n3\n1\n1\n2\n", 
                   "1 O|O|O\n  -----\n2 .|X|.\n  -----\n3 X|.|X\n  -----\n"+
                   "Game Over: O wins");
    }
        
    @Test
    public void checkpoint7Test2()
    {
        mainIOTest("2\n2\n1\n1\n3\n3\n3\n1\n1\n2\n2\n1\n", 
                   "1 O|X|.\n  -----\n2 O|X|.\n  -----\n3 O|.|X\n  -----\n"+
                   "Game Over: O wins");
    }
        
    @Test
    public void checkpoint7Test3()
    {
        mainIOTest("1\n1\n1\n2\n1\n3\n2\n1\n2\n2\n2\n3\n3\n1\n", 
                   "1 X|O|X\n  -----\n2 O|X|O\n  -----\n3 X|.|.\n  -----\n"+
                   "Game Over: X wins");
    }
        
    @Test
    public void checkpoint7Test4()
    {
        mainIOTest("1\n2\n1\n1\n2\n2\n2\n1\n3\n2\n", 
                   "1 O|X|.\n  -----\n2 O|X|.\n  -----\n3 .|X|.\n -----\n"+
                   "Game Over: X wins");
    }
        
    @Test
    public void checkpoint7Test5()
    {
        mainIOTest("2\n2\n1\n1\n3\n1\n1\n3\n1\n2\n3\n2\n2\n1\n2\n3\n3\n3\n", 
                   "1 O|X|O\n  -----\n2 X|X|O\n  -----\n3  X|O|X\n  -----\n"+
                   "Game Over: no winner");
    }    
     
}

