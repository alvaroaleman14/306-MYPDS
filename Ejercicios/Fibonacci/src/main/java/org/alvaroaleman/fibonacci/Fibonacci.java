package org.alvaroaleman.fibonacci;

/*
    Author: Álvaro Alemán Rando
    Program: Fibonacci
    2022.
 */

public class Fibonacci {
    // Método que hace la función fibonacci de forma recursiva
    public int compute(int value) throws RuntimeException {
        if (value < 0) {
            throw new RuntimeException("Negative not allowed, value: "+ value);
        }
        if (value == 0 || value == 1)
            return value;
        else
            return compute(value - 1) + compute(value - 2);
    }
}
