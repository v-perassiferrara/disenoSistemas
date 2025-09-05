package tp2.ej1;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static java.lang.Math.*;

@EqualsAndHashCode
@ToString


public class Punto {

    private final int x;
    private final int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public double distancia(Punto o) {
        long dx = (long) o.x - x;
        long dy = (long) o.y - y;
        return sqrt(dx*dx + dy*dy);
    }
}