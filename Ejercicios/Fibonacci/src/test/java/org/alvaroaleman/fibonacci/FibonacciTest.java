package org.alvaroaleman.fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
    Test cases:
    Fib 0 = 0
    Fib 1 = 1
    Fib 7 = 13
    Fib Negative = Error
 */

public class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeEach
    public void setup(){
        fibonacci = new Fibonacci();
    }

    @AfterEach
    public void finish(){
        fibonacci = null;
    }

    @Test
    public void shouldRaiseExceptionIfNegative(){
        assertThrows(RuntimeException.class, () -> fibonacci.compute(-1));
    }

    @Test
    public void shouldReturn0IfValueEquals0(){
        int expectedValue = 0;
        int obtainedValue = fibonacci.compute(0);

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    public void shouldReturn1IfValueEquals1(){
        int expectedValue = 1;
        int obtainedValue = fibonacci.compute(1);

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    public void shouldReturn13ifValueEquals7(){
        int expectedValue = 13;
        int obtainedValue = fibonacci.compute(7);

        assertEquals(expectedValue,obtainedValue);
    }




}
