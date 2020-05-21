import java.util.*;
import java.io.*;

public class LinkedList<E> implements Iterable<E> {
    private Node<E> sentinel;
    private int size = 0;

    public LinkedList(E first) {//Creates a Linkedlist object with one node from a polygon
        Node<E> n = new Node<E>(first);
        sentinel = new Node<E>();
        sentinel.setNext(n);
        sentinel.setPrevious(n);
        size++;

    }

    public LinkedList() {//creates an empty LinkedList
        sentinel = new Node<E>();
    }

    private Node<E> getSentinel(){
        return sentinel;
    }

    private void insert(Node<E> before,E inserting){//insert a item before a specified node
        Node<E> newN = new Node<E>(inserting);
        newN.setNext(before);
        newN.setPrevious(before.getPrevious());
        before.getPrevious().setNext( newN);
        before.setPrevious(newN);
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

    public void append(E p) {//Add a new node at the end of the LL
        Node<E> n = new Node<E>(p);
        n.setNext(sentinel);
        n.setPrevious(sentinel.getPrevious());
        sentinel.getPrevious().setNext(n);
        sentinel.setPrevious(n);
        size++;
    }

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

    public int getSize(){
        return size;
    }

    public void insertSorted(E input){
        //insert a new node into it's correctly sorted position

        Node<E> comp = sorted.sentinel.getNext();//The node we are comparing to which changes
        if (getSize()==0){
            append(input);
            return;
        }
        for (int i = 0; i < getSize(); i++) {
            if (compareTo(input,comp.getData())<0){
                sorted.insert(comp,input);
                return;
            } else if (i==getSize()-1){
                append(input);
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

    private class ListIterator implements Iterator<E> {//implementation of iterator
        private Node<E> current;


        public ListIterator(){//implementation of iterator
            current = sentinel;
        }

        public boolean hasNext(){//implementation of iterator check for next
            if (current.getNext()!=sentinel){
                return true;
            }
            return false;
        }


        public E next(){//implementation of iterator move to next and return data

            current = current.getNext();
            E data = current.getData();
            return data;
        }

        public void remove(){//required to implement iterator but not used
            throw new UnsupportedOperationException();
        }
    }
}

