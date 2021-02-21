public class Point2d {
    protected double xCoord;
    protected double yCoord;

    public Point2d(double x, double y){
        xCoord = x;
        yCoord = y;
    }
    public Point2d(){
        xCoord = 0;
        yCoord = 0;
    }
    public double getX(){
        return xCoord;
    }
    public double getY(){
        return yCoord;
    }
    public void setX(double val) {
        xCoord = val;
    }
    public void setY(double val) {
        yCoord = val;
    }
    public boolean equals(Point2d point){
        return (this.yCoord == point.yCoord && this.xCoord == point.xCoord);
    }
}