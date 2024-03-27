package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyStringTest {

    // Tests for valid inputs where the substring is found in the string
    @Test
    public void testIndexOfStringWithValidInputs() {
        MyString myString = new MyString();
        assertEquals("Substring 'he' found at start of 'hello'", 0, myString.indexOfString("hello", "he", 0));
        assertEquals("Substring 'll' found in the middle of 'hello'", 2, myString.indexOfString("hello", "ll", 0));
        assertEquals("Substring 'lo' found at the end of 'hello'", 3, myString.indexOfString("hello", "lo", 0));
        assertEquals("Substring 'hello' equals the string 'hello'", 0, myString.indexOfString("hello", "hello", 0));
    }

    // Tests with valid inputs and non-zero starting positions
    @Test
    public void testIndexOfStringWithValidInputAndNonZeroPosition() {
        MyString myString = new MyString();
        assertEquals("Substring 'llo' found in 'hello' starting at position 2", 2, myString.indexOfString("hello", "llo", 2));
        assertEquals("Substring 'hello' not found in 'hello' starting at position 1", -1, myString.indexOfString("hello", "hello", 1));
    }

    // Tests when the substring is not found in the string
    @Test
    public void testIndexOfStringWithSubstringNotFound() {
        MyString myString = new MyString();
        assertEquals("Substring 'world' not found in 'hello'", -1, myString.indexOfString("hello", "world", 0));
        assertEquals("Substring 'he' not found when starting from index 1 in 'hello'", -1, myString.indexOfString("hello", "he", 1));
    }

    // Tests when the starting position is out of bounds
    @Test
    public void testIndexOfStringWithPositionOutOfBounds() {
        MyString myString = new MyString();
        assertEquals("Starting position is beyond the string length", -1, myString.indexOfString("hello", "he", 6));
        assertEquals("Starting position is at the end of the string", -1, myString.indexOfString("hello", "", 5));
    }

    // Tests with empty strings
    @Test
    public void testIndexOfStringWithEmptyStrings() {
        MyString myString = new MyString();
        assertEquals("Both strings are empty", -1, myString.indexOfString("", "", 0));
        assertEquals("Searching for non-empty substring in an empty string", -1, myString.indexOfString("", "he", 0));
        assertEquals("Searching for an empty substring in a non-empty string", -1, myString.indexOfString("hello", "", 0));
    }

    // Continue with tests for null inputs
    @Test
    public void testIndexOfStringWithNullInputs() {
        MyString myString = new MyString();
        assertEquals("First string is null", -1, myString.indexOfString(null, "test", 0));
        assertEquals("Second string is null", -1, myString.indexOfString("test", null, 0));
        assertEquals("Both strings are null", -1, myString.indexOfString(null, null, 0));
    }

    // Tests when the substring is longer than the string
    @Test
    public void testIndexOfStringWhenSubstringIsLongerThanString() {
        MyString myString = new MyString();
        assertEquals("Substring 'hellohello' is longer than 'hello'", -1, myString.indexOfString("hello", "hellohello", 0));
    }

    // Tests replace for non-null values
    @Test
    public void testReplaceForNonNullValues() {
        MyString myString = new MyString();
        assertEquals("Replacing 'dog' with 'cat' in 'dogLover'", "catLover", myString.replace("dogLover", "dog", "cat"));
    }

}