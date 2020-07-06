package com.abdo;

import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray {
    private static final SecureRandom generator = new SecureRandom();
    private final int[]array;
    private int writeIndex = 0;


    public SimpleArray(int size) {
        this.array = new int[size];
    }

    public synchronized void add(int value) {

        int position = writeIndex;

        try {
            // put thread to sleep for 0-499 miliseconds
            Thread.sleep(generator.nextInt(500));

        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        // put value in appropriated index
        array[position] = value;
        System.out.printf("%s wrote %2d to element %d.%n",
                Thread.currentThread().getName(), value, position);

        ++writeIndex;
        System.out.printf("Next write index: %d%n", writeIndex);
    }// end of add method

    @Override
    public synchronized String toString() {
        return Arrays.toString(array);
    }
}
