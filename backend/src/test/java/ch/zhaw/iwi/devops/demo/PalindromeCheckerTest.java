package ch.zhaw.iwi.devops.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//Quelle der Idee https://alonso-delarte.medium.com/palindrome-checker-is-a-better-basic-example-of-test-driven-development-239a01d11fc8
public class PalindromeCheckerTest {

    @Test
    public void testIsPalindromeWithEvenLengthString() {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        assertTrue(palindromeChecker.isPalindrome("racecar"));
        assertTrue(palindromeChecker.isPalindrome("deified"));
        assertFalse(palindromeChecker.isPalindrome("hello"));
    }

    @Test
    public void testIsPalindromeWithOddLengthString() {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        assertTrue(palindromeChecker.isPalindrome("level"));
        assertTrue(palindromeChecker.isPalindrome("radar"));
        assertFalse(palindromeChecker.isPalindrome("world"));
    }

    @Test
    public void testIsPalindromeWithNullInput() {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        assertThrows(IllegalArgumentException.class, () -> palindromeChecker.isPalindrome(null));
    }

    @Test
    public void testIsPalindromeWithSingleCharacterInput() {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        assertTrue(palindromeChecker.isPalindrome("a"));
        assertFalse(palindromeChecker.isPalindrome("b"));
    }

    @Test
    public void testIsPalindromeWithWhitespaceInput() {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        assertTrue(palindromeChecker.isPalindrome("race car"));
        assertTrue(palindromeChecker.isPalindrome("A man a plan a canal Panama"));
        assertFalse(palindromeChecker.isPalindrome("hello world"));
    }

    @Test
    public void testIsPalindromeWithEmptyString() {
    PalindromeChecker palindromeChecker = new PalindromeChecker();
    assertTrue(palindromeChecker.isPalindrome(""));
    }

    @Test
    public void testIsPalindromeWithPunctuation() {
    PalindromeChecker palindromeChecker = new PalindromeChecker();
    assertTrue(palindromeChecker.isPalindrome("A man, a plan, a canal: Panama!"));
    assertFalse(palindromeChecker.isPalindrome("Madam, I'm Adam!"));
    }

    @Test
    public void testIsPalindromeWithNumbers() {
    PalindromeChecker palindromeChecker = new PalindromeChecker();
    assertTrue(palindromeChecker.isPalindrome("12321"));
    assertFalse(palindromeChecker.isPalindrome("12345"));
    }

    @Test
    public void testIsPalindromeWithMixedCase() {
    PalindromeChecker palindromeChecker = new PalindromeChecker();
    assertTrue(palindromeChecker.isPalindrome("Racecar"));
    assertTrue(palindromeChecker.isPalindrome("Deified"));
    assertTrue(palindromeChecker.isPalindrome("Able was I ere I saw Elba"));
    assertFalse(palindromeChecker.isPalindrome("Hello"));
    }

    @Test
    public void testIsPalindromeWithNonAlphanumericCharacters() {
    PalindromeChecker palindromeChecker = new PalindromeChecker();
    assertTrue(palindromeChecker.isPalindrome("A man a plan a canal Panama!"));
    assertFalse(palindromeChecker.isPalindrome("Hello, World!"));
    }

}

