import java.lang.*;

public class PA1 {
    public static void insertionSort() {
        //insertionSort all of the items of the linkedlist into a new LinkedList
    }

    public static void main(String args[]){
        LinkedList mp = null, mpSorted = null;
        //Have a try/catch statement that reads from a user specified input file
        try{
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        }catch (Exception e){
            System.out.println("Failed");
        }
    }
}
