import java.lang.Math;
public class Point {
    private double x;
    private double y;


    Point(double xValue, double yValue){
        x = xValue;
        y = yValue;
    }
    Point(Point p){
        x = p.getX();
        y = p.getY();
    }

    public double distance(){
        double distance = Math.sqrt(x*x+y*y);
        return distance;
    }
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
    @Override
    public String toString(){
    String out = "(" + x + "0, " + y + "0)";
    return out;
    }
}