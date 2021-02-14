package uteevbkru.ball;

public class BallRunnable implements Runnable{
	private Ball ball;
	private BallComponent ballComponent;
	// Количество шагов
	public static final int STEPS = 10000;
	//за сколько миллисекунд сделается один шаг
	public static final int DELAY = 10;
	
	public BallRunnable(Ball ball, BallComponent comp) {
		this.ball = ball;
		this.ballComponent = comp;
	}
	
	public void run() {
		try{
			for(int i = 1; i <= STEPS; i++){
				ball.move(ballComponent.getBounds());

				//насколько потокобезопасна эта функция!!
				ballComponent.repaint();
				Thread.sleep(DELAY);
			}			
		}
		catch(InterruptedException ex){
			
		}
	}

}
