package uteevbkru.control;

// Этот класс задумывается как система контроля с функциями!
// 1. счета мячей 2. информирорвание о столкновении мячей  3. корректировки полета мяча

public class BallControl {
    boolean isCrash = false;
    private int countOfBall;

    public void setCountOfBall(int count) { countOfBall = count; }

    public int getCountOfBall() { return countOfBall; }

}
