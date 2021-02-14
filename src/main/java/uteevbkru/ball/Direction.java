package uteevbkru.ball;

/*
* Направление движения Шарика!
*
*/
// todo имеет только 4 возможных значения! задать их через Enum!!

import java.util.Objects;

public class Direction {
    private double dx = 0.5;
	private double dy = 0.5;

    public void setDXminus() {
	    dx = -dx;
    }

    public void setDYminus() {
	    dy = -dy;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return Double.compare(direction.getDx(), getDx()) == 0 &&
                Double.compare(direction.getDy(), getDy()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDx(), getDy());
    }
}
