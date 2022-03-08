package org.alvaroaleman.Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/*
 Author: Álvaro Alemán Rando
 Dia de laboratorio: Martes 8 de Marzo
 */

/*
    Test cases:
    1. Excepcion si un lado = 0
    2. Excepcion si un lado negativo
    3. 3 lados iguales = equilatero
    4. 2 lados iguales = isosceles
    5. 3 lados distintos = escaleno
    6. Excepcion si la suma de 2 lados <= al lado restante
 */
public class TriangleTest {

    private Triangle triangulo;

    @BeforeEach
    public void setup(){
        triangulo = new Triangle();
    }

    @AfterEach
    public void finish(){
        triangulo = null;
    }

    @Test
    public void getTypeShouldReturnRaiseExceptionIfSideEqualsZero(){
        assertThrows(RuntimeException.class, () -> triangulo.getType(0,1,1));
    }

    @Test
    public void getTypeShouldRaiseExceptionIfSideNegative(){
        assertThrows(RuntimeException.class, () -> triangulo.getType(1,-1,-1));
    }

    @Test
    public void getTypeShouldReturnEquilateralIfEverySideEqual(){
        String expectedValue = "EQUILATERAL";
        String obtainedValue = triangulo.getType(1,1,1).toString();

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    public void getTypeShouldReturnIsoscelesIf2SideEqual(){
        String expectedValue = "ISOSCELES";
        String obtainedValue = triangulo.getType(5,3,5).toString();

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    public void getTypeShouldReturnEscaleneIf3SideDifferent(){
        String expectedValue = "SCALENE";
        String obtainedValue = triangulo.getType(5,3,4).toString();

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    public void getTypeShouldRaiseExceptionIf1SideIsEqualOrLowerToTheSumOf2Sides(){
        assertThrows(RuntimeException.class, () -> triangulo.getType(1,2,3));
    }

}
