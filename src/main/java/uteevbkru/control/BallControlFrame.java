package uteevbkru.control;

import uteevbkru.Bounce;
import uteevbkru.BounceFrame;
import uteevbkru.ball.Ball;
import uteevbkru.ball.BallComponent;
import uteevbkru.ball.BallRunnable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallControlFrame extends JFrame {

    private JPanel countOfBallPanel = new JPanel();
    private JLabel label = new JLabel();

    public BallControlFrame(int countOfBall) {
        setTitle("Control");
        countOfBallPanel.add(label);
        add(countOfBallPanel, BorderLayout.SOUTH);
        pack();
    }


    public void setCountOfBall(int countOfBall) {
        label.setText("Count of Balls " + countOfBall);
        countOfBallPanel.add(label);
        add(countOfBallPanel, BorderLayout.SOUTH);
        pack();
    }

}
