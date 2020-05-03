import java.util.*;
import java.io.*;

public class MyPolygons {
    private Node sentinel, current;
    private int size = 0;

    public MyPolygons(Polygon first) {//Creates a MyPolygons object with one node from a polygon
        Node n = new Node(first);
        sentinel = new Node();
        sentinel.setNext(n);
        sentinel.setPrevious(n);
        current = n;
        size++;

    }

    public MyPolygons() {//creates an empty LinkedList
        sentinel = new Node();
    }

    public void insert(Polygon p) {//Insert a polygon in a node before current
        Node n = new Node(p);
        current.getNext().setPrevious(n);
        n.setNext(current.getNext());
        n.setPrevious(current);
        current.setNext(n);
        size++;
    }

    public void prepend(Polygon p) {//Add a new node at the start of the LL
        Node n = new Node(p);
        n.setPrevious(sentinel);
        n.setNext(sentinel.getNext());
        sentinel.getNext().setPrevious(n);
        sentinel.setNext(n);
        size++;
    }

    public void append(Polygon p) {//Add a new node at the end of the LL
        Node n = new Node(p);
        n.setNext(sentinel);
        n.setPrevious(sentinel.getPrevious());
        sentinel.getPrevious().setNext(n);
        sentinel.setPrevious(n);
        size++;
    }

    public void remove() {//remove from the start of the list
        sentinel.getNext().getNext().setPrevious(sentinel);
        sentinel.setNext(sentinel.getNext().getNext());
        sentinel.getNext().delete();
        size--;
    }

    public void reset(){//Set current to the sentinel
        current = sentinel;
    }

    public int getSize(){
        return size;
    }

    public void setCurrentNext(){
        current = current.getNext();
    }

    public void setCurrentPrev(){
        current = current.getPrevious();
    }

    public void insertSorted(Polygon p){
        //insert a new node into it's correctly sorted position
    }

    @Override
    public String toString() {//A toString method that steps through the LinkedList and outputs in in the correct format
        String out = "";
        Node stepper = sentinel.getNext();
        for (int i=0;i<size;i++){
            out += stepper.toString() + stepper.getArea() + "\n";
            stepper = stepper.getNext();
        }
        return out;
    }
}