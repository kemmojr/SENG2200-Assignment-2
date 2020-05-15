import java.util.*;
import java.io.*;

public class LinkedList<E> implements Iterable<E> {
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

    private Node<E> getSentinel(){
        return sentinel;
    }

    public void insert(Node<PlanarShape> before,Node<E> inserting){
        Node<E> newN = new Node<E>(inserting);
        before.getNext().setPrevious((Node<PlanarShape>) newN);
        newN.setNext((Node<E>) before.getNext());
        newN.setPrevious((Node<E>) before);
        before.setNext((Node<PlanarShape>) newN);
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

    /*public void append(Iterator<E> it) {//Add a new node at the end of the LL
        Node<E> n = new Node<E>(it);
        n.setNext(sentinel);
        n.setPrevious(sentinel.getPrevious());
        sentinel.getPrevious().setNext(n);
        sentinel.setPrevious(n);
        size++;
    }*/

    // return Iterator instance
    public Iterator<E> iterator(){
        return new ListIterator();
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

    public int compareTo(PlanarShape p1,PlanarShape p2){
        return p1.compareTo(p2);
    }
    public void insertSorted(LinkedList<PlanarShape> sorted, int rep){
        //insert a new node into it's correctly sorted position

        Node<E> in = sentinel.getNext();
        for (int i = 0; i < rep; i++) {//creates an iterator to step through the LinkedList and sets it to be the next node we are inserting
            in = in.getNext();
        }
        Node<PlanarShape> comp = sorted.sentinel.getNext();
        if (rep==0){
            sorted.append((PlanarShape) in.getData());
            return;
        }
        for (int i = 0; i < sorted.getSize(); i++) {
            if (compareTo((PlanarShape) in.getData(),comp.getData())<0){
                sorted.insert(comp, (Node<PlanarShape>) in);
                return;
            } else if (i==sorted.getSize()-1){
                sorted.append((PlanarShape) in.getData());
                return;
            }
            comp = comp.getNext();
        }

    }

    @Override
    public String toString() {//A toString method that steps through the LinkedList and outputs in in the correct format
        String out = "";

        Iterator<E> it = iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        return out;
    }

    private class ListIterator implements Iterator<E> {
        public Node<E> current;


        public ListIterator(){
            current = sentinel;
        }

        public boolean hasNext(){
            if (current.getNext()!=sentinel){
                return true;
            }
            return false;
        }


        public E next(){

            current = current.getNext();
            E data = current.getData();
            return data;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}

