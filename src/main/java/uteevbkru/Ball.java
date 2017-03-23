package uteevbkru;

import java.awt.Color;
import java.awt.geom.*;
import java.util.ArrayList;

public class Ball {
	private static int count_ball = 0;
	private static int midle_ball = 0;
	private static final int XS = 15;	
	private static final int YS = 15;
	private double x = count_ball*20;
	private double y = 0;
	private double dx = 0.1;
	private double dy = 0.1;
	
	private ArrayList<Color> colors = new ArrayList<Color>(); 	
	private int color;
	public Ball(){
		count_ball++;
		colors.add(Color.blue);
		colors.add(Color.cyan);
		colors.add(Color.gray);
		colors.add(Color.red);
		colors.add(Color.pink);
		colors.add(Color.red);
		colors.add(Color.darkGray);
		colors.add(Color.magenta);
		colors.add(Color.orange);
		colors.add(Color.white);		
		color = (int) (Math.random()*colors.size());
		
		boolean abc = true;
		if(x < 400){			
			midle_ball = count_ball;
		}
		else{			
			System.out.println("SHOPA"+" "+ midle_ball + " " + count_ball);			
			x  = x - ((count_ball - midle_ball)*30);			
			if(x < 10){								
				x = count_ball*20;
			}
		}
	}
	public Color getColor(){		
		return colors.get(color);
	}
	
	public void move(Rectangle2D b){
		x += dx;
		y +=dy;
		if(x < b.getMinX()){
			x = b.getMinX();
			dx = -dx;
		}
		if(x + XS >= b.getMaxX()){
			x = b.getMaxX() - XS;
			dx = -dx;
		}
		if(y < b.getMinY()){
			y = b.getMinY();
			dy = -dy;
		}
		if(y + YS >= b.getMaxY()){
			y = b.getMaxY() - YS;
			dy = -dy;
		}	
	}
	
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x,y,XS,YS);
	}
	
}
