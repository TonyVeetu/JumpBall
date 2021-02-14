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

//	public static void main(String[] args) {
//		String name = "мама мыла раму";
//		StringBuilder finalName = new StringBuilder();
//
//		for(int i = 0; i < name.length(); i++) {
//			if(i==0) {
//				finalName.append(name.substring(0,1).toUpperCase());
//				i++;
//			}
//
//			String prom = name.substring(i,i+1);
//			if(prom.equals(" ")) {
//				finalName.append(" ");
//				String upper = name.substring(i+1,i+2).toUpperCase();
//				finalName.append(upper);
//				i++;
//			} else {
//				finalName.append(prom);
//			}
//		}
//		System.out.println(finalName);
//	}
	
}
