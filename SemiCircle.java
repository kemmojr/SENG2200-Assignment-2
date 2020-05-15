import java.lang.Math;

public class SemiCircle extends PlanarShape{

    private double radius;
    Point points[];

    public SemiCircle(double x0In, double y0In, double x1In, double y1In){
        points = new Point[4];
        points[0] = new Point(x0In,y0In);
        points[1] = new Point(x1In,y1In);
        points[2] = new Point(points[0].getX() - Math.abs(points[0].getY()-points[1].getY()),points[0].getY() + Math.abs(points[0].getX()-points[1].getX()));
        points[3] = new Point(points[0].getX() + Math.abs(points[0].getY()-points[1].getY()),points[0].getY() - Math.abs(points[0].getX()-points[1].getX()));

        //radius = Math.sqrt((y1-y0)*(y1-y0)+(x1-x0)*(x1-x0));
        radius = Math.sqrt((points[1].getY()-points[0].getY())*(points[1].getY()-points[0].getY())+(points[1].getX()-points[0].getX())*(points[1].getX()-points[0].getX()));
    }

    public double area() {
        double area = (Math.PI*radius*radius)/2.0;
        return area;
    }


    public double originDistance() {
        double originDist=0, finalOriginDist=0;
        for (int i = 0; i < 4; i++) {
            originDist = points[i].distance();
            if (originDist<finalOriginDist)
                finalOriginDist = originDist;
        }
        return finalOriginDist;
    }

    @Override
    public String toString() {
        String out = "SEMI=[";
        for (int i = 0; i < 4; i++) {
            out += points[i].toString();
        }
        out += String.format("]: %6.2f", area());
        return out;
    }
}
