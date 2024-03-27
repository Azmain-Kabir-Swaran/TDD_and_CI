package org.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MyStringTest {

    // Tests indexOfString for valid inputs where the substring is found in the string
    @Test
    public void testIndexOfStringWithValidInputs() {
        MyString myString = new MyString();
        assertEquals("Substring 'he' found at start of 'hello'", 0, myString.indexOfString("hello", "he", 0));
        assertEquals("Substring 'll' found in the middle of 'hello'", 2, myString.indexOfString("hello", "ll", 0));
        assertEquals("Substring 'lo' found at the end of 'hello'", 3, myString.indexOfString("hello", "lo", 0));
        assertEquals("Substring 'hello' equals the string 'hello'", 0, myString.indexOfString("hello", "hello", 0));
    }

    // Tests indexOfString with valid inputs and non-zero starting positions
    @Test
    public void testIndexOfStringWithValidInputAndNonZeroPosition() {
        MyString myString = new MyString();
        assertEquals("Substring 'llo' found in 'hello' starting at position 2", 2, myString.indexOfString("hello", "llo", 2));
        assertEquals("Substring 'hello' not found in 'hello' starting at position 1", -1, myString.indexOfString("hello", "hello", 1));
    }

    // Tests indexOfString when the substring is not found in the string
    @Test
    public void testIndexOfStringWithSubstringNotFound() {
        MyString myString = new MyString();
        assertEquals("Substring 'world' not found in 'hello'", -1, myString.indexOfString("hello", "world", 0));
        assertEquals("Substring 'he' not found when starting from index 1 in 'hello'", -1, myString.indexOfString("hello", "he", 1));
    }

    // Tests indexOfString when the starting position is out of bounds
    @Test
    public void testIndexOfStringWithPositionOutOfBounds() {
        MyString myString = new MyString();
        assertEquals("Starting position is beyond the string length", -1, myString.indexOfString("hello", "he", 6));
        assertEquals("Starting position is at the end of the string", -1, myString.indexOfString("hello", "", 5));
    }

    // Tests indexOfString with empty strings
    @Test
    public void testIndexOfStringWithEmptyStrings() {
        MyString myString = new MyString();
        assertEquals("Both strings are empty", -1, myString.indexOfString("", "", 0));
        assertEquals("Searching for non-empty substring in an empty string", -1, myString.indexOfString("", "he", 0));
        assertEquals("Searching for an empty substring in a non-empty string", -1, myString.indexOfString("hello", "", 0));
    }

    // Test indexOfString for null inputs
    @Test
    public void testIndexOfStringWithNullInputs() {
        MyString myString = new MyString();
        assertEquals("First string is null", -1, myString.indexOfString(null, "test", 0));
        assertEquals("Second string is null", -1, myString.indexOfString("test", null, 0));
        assertEquals("Both strings are null", -1, myString.indexOfString(null, null, 0));
    }

    // Tests indexOfString when the substring is longer than the string
    @Test
    public void testIndexOfStringWhenSubstringIsLongerThanString() {
        MyString myString = new MyString();
        assertEquals("Substring 'hellohello' is longer than 'hello'", -1, myString.indexOfString("hello", "hellohello", 0));
    }

    // Test replace method for basic replacement functionality
    @Test
    public void testBasicReplace() {
        MyString myString = new MyString();
        assertEquals("Replacing 'dog' with 'cat' in 'dogLover' should return catLover", "catLover", myString.replace("dogLover", "dog", "cat"));
        assertEquals("Replacing 'bar' with 'bat' in 'barman' should return 'batman'", "batman", myString.replace("barman", "bar", "bat"));
        assertEquals("Replacing ' ' with '-' in 'hello world' should return 'hello-world'", "hello-world", myString.replace("hello world", " ", "-"));
    }

    // Test replace method for empty string
    @Test
    public void testReplaceEmptyString() {
        MyString myString = new MyString();
        assertEquals("Replacing empty string with 'abc' in 'test' should return 'test'", "test", myString.replace("test", "", "abc"));
        assertEquals("Replacing 'a' with an empty string in 'aardvark' should return 'rdvrk'", "rdvrk", myString.replace("aardvark", "a", ""));
        assertEquals("Replacing 'test' with 'exam' in empty string should return an empty string", "", myString.replace("", "test", "exam"));
    }

    // Test replace method with overlapping patterns
    @Test
    public void testReplaceWithOverlappingPatterns() {
        MyString myString = new MyString();
        assertEquals("Replacing 'aa' with 'a' in 'aaaa' should return 'aa'", "aa", myString.replace("aaaa", "aa", "a"));
        assertEquals("Replacing 'ABA' with 'AB' in 'ABABABA' should return 'ABABAB'", "ABBAB", myString.replace("ABABABA", "ABA", "AB"));
        assertEquals("Replacing '101' with '10' in '1010101' should return '10010'", "10010", myString.replace("1010101", "101", "10"));
        assertEquals("Replacing '10' with '101' in '1010101' should return '1011011011'", "1011011011", myString.replace("1010101", "10", "101"));
    }

    // Test replace method with null values
    @Test
    public void testReplaceWithNullParameters() {
        MyString myString = new MyString();
        assertNull("Replacing in a null string should return null", myString.replace(null, "find", "replace"));
        assertNull("Replacing a null 'find' string in 'source' should return null", myString.replace("source", null, "replace"));
        assertNull("Replacing 'find' with a null string in 'source' should return null", myString.replace("source", "find", null));
        assertNull("Replacing null with null in a null string should return null", myString.replace(null, null, null));
    }

    // Testing and mocking with Mockito
    @Test
    public void testReplaceWithMockedIndexOfString() {
        MyString myString = spy(new MyString());

        // Test replacing a word in a sentence
        when(myString.indexOfString("hello world", "world", 0)).thenReturn(6);
        when(myString.indexOfString("hello world", "world", 6 + "world".length())).thenReturn(-1);
        // assert the replace method's result for one replacement
        assertEquals("hello java", myString.replace("hello world", "world", "java"));

        // Test no occurrence of the substring to replace
        when(myString.indexOfString("hello world", "java", 0)).thenReturn(-1);
        // Execute and assert the replace method's result when no replacement occurs
        assertEquals("hello world", myString.replace("hello world", "java", "world"));

        // Test replacing with an empty string
        when(myString.indexOfString("hello world", "world", 0)).thenReturn(6);
        when(myString.indexOfString("hello world", "world", 6 + "world".length())).thenReturn(-1);
        // Execute and assert the replace method's result when replacing with an empty string
        assertEquals("hello ", myString.replace("hello world", "world", ""));

        // Test the source string is empty
        when(myString.indexOfString("", "world", 0)).thenReturn(-1);
        // Execute and assert the replace method's result with an empty source string
        assertEquals("", myString.replace("", "world", "java"));

        // Test the search string is empty
        assertEquals("hello world", myString.replace("hello world", "", "java"));
        // Test replacing with null values should return null
        assertNull(myString.replace(null, "world", "java"));
        assertNull(myString.replace("hello world", null, "java"));
        assertNull(myString.replace("hello world", "world", null));
    }

}