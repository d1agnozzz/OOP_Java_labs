import java.util.Scanner;

public class java_lab_2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Point3d p1 = new Point3d(in.nextDouble(), in.nextDouble(), in.nextDouble());
        Point3d p2 = new Point3d(in.nextDouble(), in.nextDouble(), in.nextDouble());
        Point3d p3 = new Point3d(in.nextDouble(), in.nextDouble(), in.nextDouble());
        System.out.println(computeArea(p1, p2, p3));
    }
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){
        double a = p1.distanceTo(p2);
        double b = p1.distanceTo(p3);
        double c = p2.distanceTo(p3);
        double p = p1.distanceTo(p2) + p1.distanceTo(p3) + p2.distanceTo(p3);
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}