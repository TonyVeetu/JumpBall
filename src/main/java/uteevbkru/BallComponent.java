package uteevbkru;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class BallComponent extends JPanel{

	private static final int DEF_WID = 450;
	private static final int DEF_HEI = 350;	
	
	private java.util.List<Ball> balls = new ArrayList<Ball>();		
	public void add(Ball a){
		balls.add(a);	
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Ball b : balls){				
			Paint p = b.getColor();
			g2.setPaint(p);
			g2.fill(b.getShape());//было draw!!
		}		
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(DEF_WID, DEF_HEI);
	}
	
}
