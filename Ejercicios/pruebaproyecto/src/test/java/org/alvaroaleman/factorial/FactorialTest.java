package org.alvaroaleman.factorial;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases:
 * factorial 0 -> 1 *
 * factorial 1 -> 1 *
 * factorial 2 -> 2 *
 * factorial 3 -> 6 *
 * factorial 6 -> 720 *
 * factorial negative number -> raises an exception
 */

public class FactorialTest {
    private Factorial factorial ;

    @BeforeEach
    public void setup() {
        factorial = new Factorial() ;
    }

    @AfterEach
    public void finish() {
        factorial = null ;
    }

    @Test
    public void shouldComputeReturnOneIfTheNumberIsZero() {
        int expectedValue = 1 ;
        int obtainedValue = factorial.compute(0) ;

        assertEquals(expectedValue, obtainedValue) ;
    }

    @Test
    public void shouldComputeReturnOneIfTheNumberIsOne() {
        int expectedValue = 1 ;
        int obtainedValue = factorial.compute(1) ;

        assertEquals(expectedValue, obtainedValue) ;
    }

    @Test
    public void shouldComputeReturnTwoIfTheNumberIsTwo() {
        int expectedValue = 2 ;
        int obtainedValue = factorial.compute(2) ;

        assertEquals(expectedValue, obtainedValue) ;
    }

    @Test
    public void shouldComputeReturnSixIfTheNumberIsThree() {
        int expectedValue = 6 ;
        int obtainedValue = factorial.compute(3) ;

        assertEquals(expectedValue, obtainedValue) ;
    }

    @Test
    public void shouldComputeReturn720IfTheNumberIs6() {
        int expectedValue = 720 ;
        int obtainedValue = factorial.compute(6) ;

        assertEquals(expectedValue, obtainedValue) ;
    }

    @Test
    public void shouldComputeOfANegativeNumberRaiseAnException() {
        assertThrows(RuntimeException.class, () -> factorial.compute(-1)) ;
    }

    @ParameterizedTest
    @ValueSource (ints = {0,1,2,3,6})
    public void pruebaParameterizedTest(int numero){
        int [] resultados = {1,1,2,6,720};
        assertFalse(Arrays.asList(resultados).contains(factorial.compute(numero)));
    }
}