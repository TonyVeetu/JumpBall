package uteevbkru.ball;

import static uteevbkru.ball.BallRunnable.DELAY;
import static uteevbkru.ball.BallRunnable.STEPS;

public class CheckDistanceRunnable implements Runnable {
    private BallComponent ballComponent;

    public CheckDistanceRunnable(BallComponent comp) {
        ballComponent = comp;
    }

    public void run() {
        try{
            for(int i = 1; i <= STEPS; i++){
                ballComponent.checkDistanseBetwinBalls();
                Thread.sleep(DELAY);
            }
        }
        catch(InterruptedException ex){

        }
    }
}
