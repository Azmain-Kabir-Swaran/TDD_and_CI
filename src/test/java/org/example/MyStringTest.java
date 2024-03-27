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

    // Tests when the substring is not found in the string
    @Test
    public void testIndexOfStringWithSubstringNotFound() {
        MyString myString = new MyString();
        assertEquals("Substring 'world' not found in 'hello'", -1, myString.indexOfString("hello", "world", 0));
        assertEquals("Substring 'he' not found when starting from index 1 in 'hello'", -1, myString.indexOfString("hello", "he", 1));
    }

}