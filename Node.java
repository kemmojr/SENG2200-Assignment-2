import java.util.*;

public class Node {
    //next & previous pointers of data type PlanarShape and pointer
    private PlanarShape data;
    private Node next;
    private Node previous;

    public Node(PlanarShape p){//Creates a node with data PlanarShape
        next = this;
        previous = this;
        data = p;
    }

    public Node(Node n){//Copy constructor
        next = this;
        previous = this;
        data = n.data;
    }

    public Node(){
        data = null;
        next = this;
        previous = this;
    }

    public Node(PlanarShape p, Node nxt, Node prev){//creates a node and places it in a manual position
        next = nxt;
        previous = prev;
        data = p;
    }

    public void setNext(Node nxt){
        next = nxt;
    }

    public void setPrevious(Node prev){
        previous = prev;
    }

    public Node getNext(){
        return next;
    }

    public Node getPrevious(){
        return previous;
    }

    public void delete(){//deletes a node (setting the data to null)
        data = null;
        next = null;
        previous = null;
    }

    public String getArea(){//calls PlanarShape area function and checks to see if the output is to 2 decimal places and if not then a 0 is added
        String out = "" + data.area();
        double d= data.area();
        String text = Double.toString(Math.abs(d));
        int numOfInt = text.indexOf('.');
        int decimalPlaces = text.length() - numOfInt - 1;
        if (decimalPlaces==1){
            out += "0";
            return out;
        }
        return out;
    }

    /*public boolean comesBefore(Node n){//returns true if this.area() < p.area()
        return data.comesBefore(n.data);
    }*/

    @Override
    public String toString() {//how to convert the object to a string
        String out = "";
        out += data.toString();
        return out;
    }

}
