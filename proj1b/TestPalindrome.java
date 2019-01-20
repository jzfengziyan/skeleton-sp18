import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offby1 = new OffByOne();
    static OffByN offby5 = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("abba"));
        assertTrue(palindrome.isPalindrome("abcba"));
    }

    @Test
    public void testIsPalindrome_offByOne(){
        assertTrue(palindrome.isPalindrome("flake", offby1));
        assertTrue(palindrome.isPalindrome("a", offby1));
        assertTrue(palindrome.isPalindrome("", offby1));
        assertTrue(palindrome.isPalindrome("flke", offby1));
        assertFalse(palindrome.isPalindrome("abba", offby1));
    }

    @Test
    public void testIsPalindrome_offBy5(){
        assertTrue(palindrome.isPalindrome("015", offby5));
        assertTrue(palindrome.isPalindrome("a", offby5));
        assertTrue(palindrome.isPalindrome("", offby5));
        assertTrue(palindrome.isPalindrome("0165", offby5));
        assertFalse(palindrome.isPalindrome("abba", offby5));
    }
}
