import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.round;

public class Point3d extends Point2d {

    protected double zCoord;

    public Point3d() {
        super();
        zCoord = 0;
    }

    public Point3d(double x, double y, double z) {
        super(x, y);
        zCoord = z;
    }

    public void setZ(double val) {
        zCoord = val;
    }

    public double getZ() {
        return zCoord;
    }

    public boolean equals(Point3d point) {
        return (this.getX() == point.getX() && this.getY() == point.getY() && this.getZ() == point.getZ());
    }

    public double distanceTo(Point3d point) {
        return round(sqrt(pow(this.xCoord - point.xCoord, 2) + pow(this.yCoord - point.yCoord, 2) + pow(this.zCoord - point.zCoord, 2)) * 100) / 100d;
    }
}