package com.swingworker;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FibonacciNumbers extends JFrame {

    // components for calculating the Fibonacci of user entered values
    private final JPanel workerJPanel =
            new JPanel(new GridLayout(2, 2, 5, 5));
    private final JTextField numberJTextField = new JTextField();
    private final JButton goJButton = new JButton("GO");
    private final JLabel fibonacciJLabel = new JLabel();

    // components fro variables for getting the next Fibonacci number
    private final JPanel eventThreadJPanel =
            new JPanel(new GridLayout(2, 2, 5, 5));
    private long n1 = 0;
    private long n2 = 1;
    private int count = 1;
    private final JLabel nJLabel = new JLabel("Fibonacci of 1");
    private final JLabel nFibonacciJLabel =
            new JLabel(String.valueOf(n2));
    private final JButton nextNumberJButoon = new JButton("Next Number");


    public FibonacciNumbers() {
        super("Fibonacci Numbers");
        setLayout(new GridLayout(2, 1, 10, 10));

        // add GUI components to the SwingWorker panel
        workerJPanel.setBorder(new TitledBorder(
                new LineBorder(Color.BLACK),"With SwingWorkder"
        ));
        workerJPanel.add(new JLabel("Get Fibonacci"));
        workerJPanel.add(numberJTextField);
        goJButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int n;

                        try {
                            // retrieve user's input as an integer
                            n = Integer.parseInt(numberJTextField.getText());
                        } catch (NumberFormatException e1) {
                            fibonacciJLabel.setText("Enter An Integer");
                            return;
                        }

                        fibonacciJLabel.setText("Calculating...");

                        BackgroundCalculator task =
                                new BackgroundCalculator(n, fibonacciJLabel);
                        task.execute();
                    }
                }
        ); // end call to AddActionListener
        workerJPanel.add(goJButton);
        workerJPanel.add(fibonacciJLabel);


        // add GUI components to the event-dispatching thread panel
        eventThreadJPanel.setBorder(new TitledBorder(
                new LineBorder(Color.BLACK), "Without SwingWorker"
        ));

        eventThreadJPanel.add(nJLabel);
        eventThreadJPanel.add(nFibonacciJLabel);
        nextNumberJButoon.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        long temp = n1 + n2;
                        n1 = n2;
                        n2 = temp;
                        ++count;

                        nJLabel.setText("Fibonacci of " + count + ": ");
                        nFibonacciJLabel.setText(String.valueOf(n2));
                    }
                }
        );
        eventThreadJPanel.add(nextNumberJButoon);

        add(workerJPanel);
        add(eventThreadJPanel);
        setSize(275, 200);
        setVisible(true);

    }

    public static void main(String[] args) {
        FibonacciNumbers application = new FibonacciNumbers();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}


