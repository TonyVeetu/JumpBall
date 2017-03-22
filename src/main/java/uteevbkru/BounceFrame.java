package uteevbkru;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceFrame extends JFrame{

	private BallComponent comp;
	public static final int STEPS = 1000;
	public static final int DELAY = 30;
	
	public BounceFrame(){
		setTitle("Bounce");
		
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
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
		add(butPanel, BorderLayout.SOUTH);
		pack();		
	}
	
	public void addButton(Container c, String title, ActionListener listener){
		JButton but = new JButton(title);
		c.add(but);
		but.addActionListener(listener);		
	}
	
	public void addBall(){
//		try{
			Ball b = new Ball();
			comp.add(b);
			
			Runnable r = new BallRunnable(b, comp);
			Thread t = new Thread(r);
			t.start();
//			for(int i = 1; i <= STEPS; i++){
//				b.move(comp.getBounds());
//				comp.paint(comp.getGraphics());
//				Thread.sleep(DELAY);
//			}		
//		}
//		catch(InterruptedException e ){
//			
//		}
	}
	
}
