package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyStringTest {

    @Test
    public void indexOfString() {
        MyString myString = new MyString();
        assertEquals("Expected return value should be 0", 0, myString.indexOfString("hello", "he", 0));
    }
}