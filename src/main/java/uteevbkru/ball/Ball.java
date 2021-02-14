package uteevbkru.ball;

import java.awt.Color;
import java.awt.geom.*;
import java.util.ArrayList;

public class Ball {
	private static int count_ball = 0;
	private static int midle_ball = 0;
	//размер Шарика
	private static final int XS = 55;
	private static final int YS = 55;
	
	private double x = count_ball*XS;
	private double y = 0;

	//прирост по координтам
	private Direction direction = new Direction();

	private ArrayList<Color> colors = new ArrayList<Color>(); 	
	private int color;

	public Ball() {
		count_ball++;
		setColors();
		color = (int) (Math.random() * colors.size());

		if (x < 400){
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

	private void setColors() {
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
	}

	public Color getColor(){		
		return colors.get(color);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/* чтобы двинутья каждый шар
        должен получить значения
        ПРЯМОУГОЛЬНИКА */
	public void move(Rectangle2D frame){
		synchronized (this) {
			x += direction.getDx();
			y += direction.getDy();
		}
		if(x < frame.getMinX()){
			x = frame.getMinX();
			direction.setDXminus();
		}
		if(x + XS >= frame.getMaxX()){
			x = frame.getMaxX() - XS;
			direction.setDXminus();
		}
		if(y < frame.getMinY()){
			y = frame.getMinY();
			direction.setDYminus();
		}
		if(y + YS >= frame.getMaxY()){
			y = frame.getMaxY() - YS;
			direction.setDYminus();
		}	
	}
	
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x,y,XS,YS);
	}

	public double getX() {return x; }

	public double getY() {return y; }

	public static int getXS() { return XS; }

	public static int getYS() {
		return YS;
	}
}
