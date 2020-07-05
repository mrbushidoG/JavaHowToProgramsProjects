package com.abdo;

public class ArrayWriter implements Runnable {
    
    private final SimpleArray sharedSimpleArray;
    private final int startValue;

    public ArrayWriter(int startValue,SimpleArray sharedSimpleArray) {
        this.sharedSimpleArray = sharedSimpleArray;
        this.startValue = startValue;
    }
    
    public void run() {
        for (int i = 0; i < startValue + 3; i++) {
            sharedSimpleArray.add(i);
        }
    }
} // end of ArrayWriter Class


