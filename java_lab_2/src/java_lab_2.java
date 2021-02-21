
public class java_lab_2 {
    public static void main(String[] args) {
        // Point2d

        // initializing
        Point2d a2 = new Point2d();
        Point2d b2 = new Point2d(0, 0);
        Point2d c2 = new Point2d(5.3, 6.7);

        // comparing
        System.out.println(a2 == b2);
        System.out.println(a2.equals(b2));
        System.out.println(a2.equals(c2));

        // methods testing
        a2.setX(5.3);
        System.out.println(a2.getX());
        a2.setY(6.7);
        System.out.println(a2.getX());
        System.out.println(a2.equals(c2));

        System.out.println("\n");

        // Point3d

        // initializing
        Point3d a3 = new Point3d();
        Point3d b3 = new Point3d(0, 0, 0);
        Point3d c3 = new Point3d(1, 2, 3);

        // comparing
        System.out.println(a3 == b3);
        System.out.println(a3.equals(b3));
        System.out.println(a3.equals(c3));

        // distanceTo test
        Point3d pa = new Point3d();
        Point3d pb = new Point3d(1,1,1);
        System.out.println(pa.distanceTo(pb));

    }
}