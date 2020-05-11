import java.lang.*;
import java.util.*;
import java.io.*;

public class PA2 {
    public static void insertionSort() {
        //insertionSort all of the items of the linkedlist into a new LinkedList
    }

    public static void main(String args[]){
        LinkedList mp = null, mpSorted = null;
        int numOfPoints;
        //Have a try/catch statement that reads from a user specified input file
        try {//A try/catch statement to import from a file
            Scanner reader = new Scanner(new FileInputStream("input.txt"));//Scanner reader object to use for stepping through the data in the file

            boolean b = false; //A variable to break from the while loop
            String type = reader.next();

            int count = 0;

            while (b) {


                if (type.equals("P")){//If there is a p, meaning another polygon exists, continue looping
                    b = true;
                    numOfPoints = reader.nextInt(); //The number of points in the polygon
                } else if (type.equals("C")){

                } else if (type.equals("S")){

                }

                if (type.equals("C")){
                    double x,y,radius;
                    x = reader.nextDouble();
                    y = reader.nextDouble();
                    radius = reader.nextDouble();
                    Circle c = new Circle(x,y,radius);
                } else if (type.equals("S")){
                    double x0,y0,x1,y1,radius;
                    x0 = reader.nextDouble();
                } else if (type.equals("P")){
                    Polygon p = new Polygon(numOfPoints);//creates empty Polygon with correct array size
                }


                for (int i = 0; i < numOfPoints; i++) {//Loops through and adds the necessary number of points to Polygon
                    p.addPoint(reader.nextDouble(), reader.nextDouble());//Adds a point with the two x & y co-ordinate values from the file
                }
                if (count==0) {
                    //mp = new LinkedList(p);//create a new MyPolygon for storing the Polygons
                } else {
                    //mp.append(p);//Otherwise add the polygon to the LinkedList
                }
                count++;
                try{
                    if (reader.next().equals("P")){//checks if there is another Polygon and if not then break from the while loop
                        continue;
                    } else {
                        b = false;
                    }
                } catch (Exception e){
                    //A catch to avoid errors when reading from file
                    break;
                }


            }

            //mpSorted = new MyPolygons(mp);//creates empty MP for putting a sorted LinkedList in
        } catch (Exception e){
            //Exception code for if there is a problem reading from file
            System.out.println("Error");
        }
    }
}
