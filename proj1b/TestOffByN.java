import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByN(5);

    // Your tests go here.
    @Test
    public void testEqualChars(){
        assertFalse(offByOne.equalChars('0', '1'));
        assertTrue(offByOne.equalChars('0', '5'));
    }
}
