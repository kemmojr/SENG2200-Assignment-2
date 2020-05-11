import java.lang.Math;

public class Circle extends PlanarShape {
    private double x, y, radius;

    public Circle(double xIn, double yIn, double radiusIn){
        x = xIn;
        y = yIn;
        radius = radiusIn;
    }

    public double area(){
        double area = Math.PI*radius*radius;
        return area;
    }

    public double originDistance(){
        double originDist;
        originDist = Math.sqrt(x*x+y*y);
        originDist -= radius;
        return originDist;
    }

    @Override
    public String toString() {
        return "CIRC=[" + "("+x+", "+y+") "+radius+"]: "+area();
    }
}

