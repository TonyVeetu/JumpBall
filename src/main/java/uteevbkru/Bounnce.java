package uteevbkru;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//abcdefghiijklmnopqrstuvwxyz

//qwert yuiop
//asdfg hjkl
//zxcvb nm

public class Bounnce {
		
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
