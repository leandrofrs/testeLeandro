package com.leandro.teste;

/**
 * Simple Hello World application for testing CI/CD pipeline
 */
public class App {
    
    public static void main(String[] args) {
        System.out.println("Hello World from Leandro's Test App!");
        
        App app = new App();
        String greeting = app.getGreeting("DevOps Evangelist");
        System.out.println(greeting);
    }
    
    /**
     * Generate a personalized greeting
     * @param name the name to greet
     * @return formatted greeting message
     */
    public String getGreeting(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello, Anonymous!";
        }
        return String.format("Hello, %s! Welcome to the Java CI/CD Pipeline.", name);
    }
    
    /**
     * Calculate the sum of two numbers
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Check if a number is even
     * @param number the number to check
     * @return true if even, false if odd
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}