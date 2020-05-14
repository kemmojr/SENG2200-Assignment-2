import java.util.*;
import java.io.*;

public class LinkedList<E> implements Iterator<E> {
    private Node<E> sentinel, current;
    private int size = 0;

    public LinkedList(E first) {//Creates a Linkedlist object with one node from a polygon
        Node<E> n = new Node<E>(first);
        sentinel = new Node<E>();
        sentinel.setNext(n);
        sentinel.setPrevious(n);
        current = n;
        size++;

    }

    public LinkedList() {//creates an empty LinkedList
        sentinel = new Node<E>();
    }

    public void insert(E p) {//Insert a a generic object in a node before current
        Node<E> n = new Node<E>(p);
        current.getNext().setPrevious(n);
        n.setNext(current.getNext());
        n.setPrevious(current);
        current.setNext(n);
        size++;
    }

    public void insert(Node<E> n){
        Node<E> newN = new Node<E>(n);
        current.getNext().setPrevious(newN);
        n.setNext(current.getNext());
        n.setPrevious(current);
        current.setNext(newN);
        size++;
    }

    public void prepend(E p) {//Add a new node at the start of the LL
        Node<E> n = new Node<E>(p);
        n.setPrevious(sentinel);
        n.setNext(sentinel.getNext());
        sentinel.getNext().setPrevious(n);
        sentinel.setNext(n);
        size++;
    }

    public void prepend(Node<E> n1) {//Add a new node at the start of the LL
        Node<E> n = new Node<E>(n1);
        n.setPrevious(sentinel);
        n.setNext(sentinel.getNext());
        sentinel.getNext().setPrevious(n);
        sentinel.setNext(n);
        current = sentinel;
        size++;
    }

    public void append(E p) {//Add a new node at the end of the LL
        Node<E> n = new Node<E>(p);
        n.setNext(sentinel);
        n.setPrevious(sentinel.getPrevious());
        sentinel.getPrevious().setNext(n);
        sentinel.setPrevious(n);
        size++;
    }

    public void append(Node<E> n1) {//Add a new node at the end of the LL
        Node<E> n = new Node<E>(n1);
        n.setNext(sentinel);
        n.setPrevious(sentinel.getPrevious());
        sentinel.getPrevious().setNext(n);
        sentinel.setPrevious(n);
        size++;
    }

    @Override
    public boolean hasNext() {
        boolean out;
        if (this.next()!=null){
            return true;
        }
        return false;
    }

    @Override
    public E next() {
        E out;
        out = this.next();
        return out;
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

    public void insertSorted(E p){
        //insert a new node into it's correctly sorted position
    }
    public void insertSorted(LinkedList<PlanarShape> sorted){
        //insert a new node into it's correctly sorted position

        Node<PlanarShape> node = null;

        if (sorted.getSize()==0){
            current = sentinel.getNext();
            node = (Node<PlanarShape>) current;
            sorted.prepend(node);
            //sorted.current = sorted.current.getNext();
            return;
        }
        setCurrentNext();

        Node<PlanarShape> n = sorted.sentinel.getNext();

        for (int i = 0; i <= size; i++) {
            node = (Node<PlanarShape>) current;

            if (n.compareTo(node)<0){
                sorted.insert(node);
                sorted.setCurrentNext();
                return;
            }else {
                setCurrentNext();
            }
        }
        sorted.append(node);
        sorted.setCurrentNext();
    }

    @Override
    public String toString() {//A toString method that steps through the LinkedList and outputs in in the correct format
        String out = "";
        Node<E> stepper = sentinel.getNext();
        for (int i=0;i<size;i++){
            out += stepper.toString() + "\n";
            stepper = stepper.getNext();
        }
        return out;
    }
}