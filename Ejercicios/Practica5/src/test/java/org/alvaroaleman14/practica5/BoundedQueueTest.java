package org.alvaroaleman14.practica5;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*

Pruebas:
1- La cola creada nueva está vacía
2- Put mete un elemento y la cola no es falsa.
3- Get devuelve el mismo elemento que le hemos introducido
4- Añadimos 3 elementos a una cola y esta está llena

 */

public class BoundedQueueTest {
    private BoundedQueue queue;

    @BeforeEach
    public void setUp() {
        this.queue = new BoundedQueue(3);
    }

    @Test
    public void testEmptyQueue() {
        assertTrue(this.queue.isEmpty());
    }

    @Test
    public void testPutAddsAnElementAndQueueNotEmpty() {
        String newElement = "Hi, I am new";
        this.queue.put(newElement);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testGetReturnsSameElementWeAdded() {
        String newElement = "Hi, I am new";
        this.queue.put(newElement);
        assertEquals(newElement, this.queue.get());
    }

    @Test
    public void testAdding3ElementsToCapacity3QueueMakesItFull() {
        String el1, el2, el3;
        el1 = "I'm first";
        el2 = "I'm second";
        el3 = "I'm third";

        this.queue.put(el1);
        this.queue.put(el2);
        assertFalse(this.queue.isFull());

        this.queue.put(el3);
        assertTrue(this.queue.isFull());
    }

}
