package uteevbkru;

import java.awt.geom.*;

public class Ball {
	private static int count_ball = 0;
	private static final int XS = 15;	
	private static final int YS = 15;
	private double x = 0 + count_ball*20;
	private double y = 0;
	private double dx = 0.1;
	private double dy = 0.1;
	//TODO color!!!!!
	public Ball(){
		count_ball++;
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
