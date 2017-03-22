package uteevbkru;

public class BallRunnable implements Runnable{
	private Ball b;
	private BallComponent comp;
	public static final int STEPS = 10000;
	public static final int DELAY = 3;
	
	public BallRunnable(Ball b, BallComponent comp){
		this.b = b;
		this.comp = comp;
	}
	
	public void run(){
		try{
			for(int i = 1; i <= STEPS; i++){
				b.move(comp.getBounds());
				comp.repaint();
				Thread.sleep(DELAY);
			}			
		}
		catch(InterruptedException ex){
			
		}
	}

}
