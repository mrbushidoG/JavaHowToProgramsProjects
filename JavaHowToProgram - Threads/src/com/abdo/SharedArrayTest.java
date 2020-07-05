package com.abdo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {

    public static void main(String[] args) {

        // construct the shared object
        SimpleArray simpleArray = new SimpleArray(6);

        // create two tasks to write to shared SimpleArray object
        ArrayWriter writer1 = new ArrayWriter(1, simpleArray);
        ArrayWriter writer2 = new ArrayWriter(11, simpleArray);

        ExecutorService execute = Executors.newCachedThreadPool();
        execute.execute(writer1);
        execute.execute(writer2);

        execute.shutdown();

        try {
            boolean taskEnded = execute.awaitTermination(1, TimeUnit.MINUTES);

            if (taskEnded) {
                System.out.printf("%nContents of SimpleArray%n");
                ;
                System.out.println(simpleArray);

            } else {
                System.out.println("Time out while waiting");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
