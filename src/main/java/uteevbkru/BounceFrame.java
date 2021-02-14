package uteevbkru;

import uteevbkru.ball.Ball;
import uteevbkru.ball.BallComponent;
import uteevbkru.ball.BallRunnable;
import uteevbkru.ball.CheckDistanceRunnable;
import uteevbkru.control.BallControlFrame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceFrame extends JFrame{

	private BallComponent ballComponent;
	public static final int STEPS = 1000;
	public static final int DELAY = 30;
	private int countOfBall;
	private BallControlFrame ballControlFrame = new BallControlFrame(0);
	
	public BounceFrame() {
		setTitle("Bounce");
		ballComponent = new BallComponent();
		add(ballComponent, BorderLayout.CENTER);
		JPanel butPanel = new JPanel();
		addButton(butPanel, "Start", new ActionListener() {			
			public void actionPerformed(ActionEvent event) {
				addBall();				
			}
		} );

		addButton(butPanel, "Close", new ActionListener() {			
			public void actionPerformed(ActionEvent event) {
				System.exit(0);				
			}
		} );
		addButton(butPanel, "getCountOfBalls", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				getCountOfBall();
			}
		} );

		add(butPanel, BorderLayout.SOUTH);
		pack();
	}
	
	public void addButton(Container c, String title, ActionListener listener) {
		JButton but = new JButton(title);
		c.add(but);
		but.addActionListener(listener);		
	}
	
	public void addBall() {
		if (countOfBall == 0) {
			Runnable distanceRunnable = new CheckDistanceRunnable(ballComponent);
			Thread distance = new Thread(distanceRunnable);
			distance.start();
		}
		countOfBall++;

		Ball ball = new Ball();
		ballComponent.add(ball);

		Runnable r = new BallRunnable(ball, ballComponent);
		Thread t = new Thread(r);
		t.start();
	}

	//todo вот тут нужно создавать ОДИН поток ДЛЯ анализа РАССТОЯНИЙ!!

	public void checkDistance() {
		//создаю поток для проверки расстояний!

	}

	//тут нужно создать новое окно!!!
	public void getCountOfBall() {
		ballControlFrame.setCountOfBall(countOfBall);
		ballControlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ballControlFrame.setVisible(true);
	}
}
