import java.lang.Math;

public class SemiCircle extends PlanarShape{

    double x0, y0, x1, y1, x2, y2, x3, y3, radius;

    public SemiCircle(double x0In, double y0In, double x1In, double y1In){
        x1 = x1In;
        y1 = y1In;
        x0 = x0In;
        y0 = y0In;
        x2 = x0 - Math.abs(y0-y1);
        y2 = y0 + Math.abs(x0-x1);
        x3 = x0 + Math.abs(y0-y1);
        y3 = y0 - Math.abs(x0-x1);
        radius = Math.sqrt((y1-y0)*(y1-y0)+(x1-x0)*(x1-x0));
    }

    public double area() {
        double area = (Math.PI*radius*radius)/2.0;
        return area;
    }


    public double originDistance() {
        double originDist=0, finalOriginDist=0;
        for (int i = 0; i < 4; i++) {
            switch (i){
                case 0: originDist = Math.sqrt(x0*x0+y0*y0);
                finalOriginDist = originDist;
                case 1: originDist = Math.sqrt(x1*x1+y1*y1);
                case 2: originDist = Math.sqrt(x2*x2+y2*y2);
                case 3: originDist = Math.sqrt(x3*x3+y3*y3);

            }
            if (originDist<finalOriginDist)
                finalOriginDist = originDist;
        }
        return finalOriginDist;
    }

    @Override
    public String toString() {
        return "SEMI=[("+x0+", "+y0+")"+"("+x1+", "+y1+")]: "+area();
    }
}
