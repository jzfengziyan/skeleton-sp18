import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars(){
        assertFalse(offByOne.equalChars('0', '0'));
        assertTrue(offByOne.equalChars('0', '1'));
        assertFalse(offByOne.equalChars('a', 'B'));
    }
}
