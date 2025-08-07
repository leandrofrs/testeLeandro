package com.leandro.teste;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for App class
 */
class AppTest {
    
    private App app;
    
    @BeforeEach
    void setUp() {
        app = new App();
    }
    
    @Test
    @DisplayName("Should return personalized greeting for valid name")
    void testGetGreetingWithValidName() {
        String result = app.getGreeting("Leandro");
        assertEquals("Hello, Leandro! Welcome to the Java CI/CD Pipeline.", result);
    }
    
    @Test
    @DisplayName("Should return anonymous greeting for null name")
    void testGetGreetingWithNullName() {
        String result = app.getGreeting(null);
        assertEquals("Hello, Anonymous!", result);
    }
    
    @Test
    @DisplayName("Should return anonymous greeting for empty name")
    void testGetGreetingWithEmptyName() {
        String result = app.getGreeting("");
        assertEquals("Hello, Anonymous!", result);
    }
    
    @Test
    @DisplayName("Should return anonymous greeting for whitespace name")
    void testGetGreetingWithWhitespaceName() {
        String result = app.getGreeting("   ");
        assertEquals("Hello, Anonymous!", result);
    }
    
    @Test
    @DisplayName("Should correctly add two positive numbers")
    void testAddPositiveNumbers() {
        int result = app.add(5, 3);
        assertEquals(8, result);
    }
    
    @Test
    @DisplayName("Should correctly add negative numbers")
    void testAddNegativeNumbers() {
        int result = app.add(-5, -3);
        assertEquals(-8, result);
    }
    
    @Test
    @DisplayName("Should correctly add zero")
    void testAddWithZero() {
        int result = app.add(5, 0);
        assertEquals(5, result);
    }
    
    @Test
    @DisplayName("Should correctly identify even numbers")
    void testIsEvenWithEvenNumber() {
        assertTrue(app.isEven(4));
        assertTrue(app.isEven(0));
        assertTrue(app.isEven(-2));
    }
    
    @Test
    @DisplayName("Should correctly identify odd numbers")
    void testIsEvenWithOddNumber() {
        assertFalse(app.isEven(3));
        assertFalse(app.isEven(1));
        assertFalse(app.isEven(-1));
    }
}