package com.abdo;// Fig. 23.3: com.abdo.PrintTask.java
// com.abdo.PrintTask class sleeps for a random time between 0 to 5 seconds

import java.security.SecureRandom;

public class PrintTask implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime; // random sleep time for the thread
    private final String taskName;


    // constructor
    public PrintTask(String taskName) {
        this.taskName = taskName;

        // pick random sleep time
        sleepTime = generator.nextInt(5000); //miliseconds
    }

    // method run contains the code that a thread will execute
    public void run() {
        try { // put thread to sleep for sleepTime amount of time
            System.out.printf("%s going to sleep for %d milliseconds.%n",
                    taskName, sleepTime);
            Thread.sleep(sleepTime);// put to sleep

        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt(); // re-interrupt the thread
        }

        // print task name
        System.out.printf("%s done sleeping%n", taskName);


    } // end of run method

}// end of com.abdo.PrintTask class
