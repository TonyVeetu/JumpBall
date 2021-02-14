package uteevbkru.ball;

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
		for (Ball ball : balls){
			Paint p = ball.getColor();
			g2.setPaint(p);
			g2.fill(ball.getShape());
		}		
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(DEF_WID, DEF_HEI);
	}


	public void checkDistanseBetwinBalls() {
		if (!balls.isEmpty()) {
			if (balls.size() >= 2) {
				for (int i = 0; i < balls.size() - 1; i++) {
					for (int j = i + 1; j < balls.size(); j++) {
						if (!getDistanceBetwinBalls(i, j)) {
							pushOfTheBalls(i,j);
						}
					}
				}
			}
		}
	}

	public void pushOfTheBalls(int i, int j) {
		Ball one = balls.get(i);
		Ball second = balls.get(j);

		if (one.getDirection().equals(second.getDirection())) {
			System.out.println("___DIRECTION IS EQAUALs!!!");
			//todo
			one.getDirection().setDYminus();
			second.getDirection().setDXminus();
		} else {
			Direction promDirect = one.getDirection();
			one.setDirection(second.getDirection());
			second.setDirection(promDirect);
		}

		//  one   second    !!!!!!!      one   second
		// dx dy  dx dy   	!! 1 !!		-dx dy  dx -dy
		// dx dy  -dx dy  	!! 2 !!      -dx dy  dx dy
		// dx dy  -dx -dy 	!! 3 !!      -dx -dy  dx dy
		// dx dy  dx -dy  	!! 4 !!      dx -dy  dx dy

		// -dx dy  dx dy    !! 5 !!     dx dy  -dx dy
		// -dx dy  -dx dy   !! 6 !!		-dx -dy  dx dy
		// -dx dy  -dx -dy  !! 7 !!		-dx -dy  -dx dy
		// -dx dy  dx -dy   !! 8 !!		-dx -dy  dx dy

		// -dx -dy  dx dy   !! 9  !!	dx dy  -dx -dy
		// -dx -dy  -dx dy  !! 10 !!	-dx dy  -dx -dy
		// -dx -dy  -dx -dy !! 11 !!	-dx dy  dx -dy
		// -dx -dy  dx -dy  !! 12 !!	dx -dy  -dx -dy

		// dx -dy  dx dy   	!! 13 !! 	 dx dy  dx -dy
		// dx -dy  -dx dy   !! 14 !! 	 -dx dy  dx -dy
		// dx -dy  -dx -dy  !! 15 !! 	-dx -dy  dx -dy
		// dx -dy  dx -dy   !! 16 !! 	-dx -dy  dx dy

		//!!!!!идея в том что я просто должен поменять направления мои шаров!

		/* double dxOne = one.getDx();
		double dxSecond = second.getDx();
		if (dxOne > 0 && dxSecond > 0) {
			second.setDx(-dxSecond);
		}
		if (dxOne > 0 && dxSecond < 0) {
			second.setDx(-dxSecond);
		}
		double dyOne = one.getDy();
		double dySecond = second.getDy();
		if (dyOne > 0 && dySecond > 0) {
			second.setDy(-dySecond);
		} */
	}


	//вернет false если есть ОПАСНОсТЬ - шары рядом!!
	private boolean getDistanceBetwinBalls(int one, int two) {
		Ball first = balls.get(one);
		Ball second = balls.get(two);

		double x1 = first.getX();
		double y1 = first.getY();

		double x2 = second.getX();
		double y2 = second.getY();

		double deltaX = x1 - x2;
		double deltaY = y1 - y2;
		if ( (Math.abs(deltaX)) < Ball.getXS() && (Math.abs(deltaY)) < Ball.getYS() ) {
			return false;
		} else {
			return true;
		}
	}
	
}
