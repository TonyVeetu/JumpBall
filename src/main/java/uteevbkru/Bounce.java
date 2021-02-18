package uteevbkru;

import uteevbkru.control.BallControlFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Bounce {
		
	public static void main(String []args){
		EventQueue.invokeLater(new Runnable()
			{
				public void run(){
					JFrame frame = new BounceFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			});
	}
}