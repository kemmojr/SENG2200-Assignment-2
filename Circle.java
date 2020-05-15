import java.lang.Math;

public class Circle extends PlanarShape {
    private double radius;
    private Point[] points;

    public Circle(double xIn, double yIn, double radiusIn){
        points = new Point[1];
        points[0] = new Point(xIn,yIn);
        radius = radiusIn;
    }

    public double area(){
        double area = Math.PI*radius*radius;
        return area;
    }

    public double originDistance(){
        double originDist;
        originDist = points[0].distance();
        originDist -= radius;
        return originDist;
    }


    @Override
    public String toString() {
        String out ="CIRC=[" + points[0]+radius;
        out += String.format("]: %6.2f", area());
        return out;
    }
}

