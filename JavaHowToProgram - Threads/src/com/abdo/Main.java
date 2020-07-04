package com.abdo;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        // create and name each runnable
        PrintTask task1 = new PrintTask("Task1");
        PrintTask task2 = new PrintTask("Task2");
        PrintTask task3 = new PrintTask("Task3");

        System.out.println("Starting Execution");


        // create ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // start the three tasks
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);


        // shut down ExecutorService -- it decided when to shut down
        executorService.shutdown();

        System.out.printf("Task Started, main ends. %n%n");
    }
}
