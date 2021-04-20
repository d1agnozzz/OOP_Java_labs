import java.awt.geom.Rectangle2D;

public class Tricorn extends FractalGenerator {


    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2;
        range.width = 4;
        range.height = 4;
    }

    @Override
    public int numIterations(double x, double y) {
        ComplexNumber c;
        c = new ComplexNumber(x, y);
        //c = new ComplexNumber(x, y);
        ComplexNumber z = new ComplexNumber(0, 0);
        int counter = 0;

        while (z.getSqrModule() < 8 && counter < MAX_ITERATIONS) {
            z = z.conjugate();
            z = z.mult(z);
            z = z.plus(c);
            counter++;
        }

        if (counter == MAX_ITERATIONS)
            return -1;
        return counter;
    }

    @Override
    public String toString() {
        return "Tricorn";
    }
}

