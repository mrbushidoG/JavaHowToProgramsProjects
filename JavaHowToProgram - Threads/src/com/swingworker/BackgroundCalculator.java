package com.swingworker;

import javax.swing.*;
import java.util.concurrent.ExecutionException;

public class BackgroundCalculator extends SwingWorker<Long, Object> {
    private final int n; // fibonacci number to calculate
    private final JLabel resultJLabel;

    public BackgroundCalculator(int n, JLabel resultJLabel) {
        this.n = n;
        this.resultJLabel = resultJLabel;
    }

    public Long doInBackground() {
        long nthFib = fibonacci(n);
        return nthFib;
    }

    // code to run on the event dispatch thread when the doInBackground returns
    protected void done() {
        try {
            // get the result of doInBackground and display it
            resultJLabel.setText(get().toString());
        } catch (InterruptedException e) {
            resultJLabel.setText("Interrupted");
        } catch (ExecutionException e) {
            resultJLabel.setText("Error encountered");
        }
    }

    // recursive fibonacci method
    public long fibonacci(long number) {
        if (number == 0 || number == 1) {
            return number;
        } else {
            return fibonacci(number - 1);
        }
    }
}
