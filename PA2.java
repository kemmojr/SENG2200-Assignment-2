import java.lang.*;
import java.util.*;
import java.io.*;

public class PA2 {
    public static void insertInOrder(LinkedList<PlanarShape> unsorted, LinkedList<PlanarShape> sorted) {
        //insertionSort all of the items of the linkedlist into a new LinkedList
        Iterator<PlanarShape> it = unsorted.Iterator();
        while(it.hasNext()){//Loop through all the elements of the unsorted list and add them in order to the sorted list
            sorted.insertSorted(it.next());
        }

    }

    public static void main(String args[]){
        LinkedList mp = null, mpSorted = null;
        LinkedList<PlanarShape> lL = new LinkedList<PlanarShape>();
        LinkedList<PlanarShape> lLSorted = new LinkedList<PlanarShape>();
        //Have a try/catch statement that reads from a user specified input file
        try {//A try/catch statement to import from a file

            Scanner reader = new Scanner(new FileInputStream(args[0]));//Scanner reader object to use for stepping through the data in the file

            while (reader.hasNext()) {
                String type = reader.next();


                if (type.equals("C")){//Checks the type against all of the different possible planar shapes
                    double x,y,radius;
                    x = reader.nextDouble();
                    y = reader.nextDouble();
                    radius = reader.nextDouble();
                    Circle c = new Circle(x,y,radius);
                    lL.append(c);
                } else if (type.equals("S")){
                    double x0,y0,x1,y1,radius;
                    x0 = reader.nextDouble();
                    y0 = reader.nextDouble();
                    x1 = reader.nextDouble();
                    y1 = reader.nextDouble();
                    SemiCircle s = new SemiCircle(x0,y0,x1,y1);
                    lL.append(s);
                } else if (type.equals("P")){
                    int numOfPoints = reader.nextInt();
                    Polygon p = new Polygon(numOfPoints);//creates Polygon 
                    for (int i = 0; i < numOfPoints; i++) {
                        double x = reader.nextDouble();
                        double y = reader.nextDouble();
                        p.addPoint(x,y);
                    }
                    lL.append(p);
                }

                }
        } catch (Exception e){
            //Exception code for if there is a problem reading from file
            System.out.println("Error");
        }



        System.out.println("Unsorted List");
        System.out.println(lL);
        System.out.println("Sorted List");



        try {
            insertInOrder(lL,lLSorted);
            System.out.println(lLSorted);
        } catch (Exception E){
            System.out.println("Sorting failed");
        }

    }
}
