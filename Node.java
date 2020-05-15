import java.util.*;

public class Node<E> {
    //next & previous pointers of data type E and pointer
    private E data;
    private Node<E> next;
    private Node<E> previous;

    public Node(E p){//Creates a node with data E
        next = this;
        previous = this;
        data = p;
    }

    public Node(Node<E> n){//Copy constructor
        next = this;
        previous = this;
        data = n.data;
    }

    public Node(){
        data = null;
        next = this;
        previous = this;
    }

    public Node(E p, Node<E> nxt, Node<E> prev){//creates a node and places it in a manual position
        next = nxt;
        previous = prev;
        data = p;
    }

    public void setNext(Node<E> nxt){
        next = nxt;
    }

    public void setPrevious(Node<E> prev){
        previous = prev;
    }

    public Node<E> getNext(){
        return next;
    }

    public Node<E> getPrevious(){
        return previous;
    }

    public E getData() {
        return data;
    }

    public void delete(){//deletes a node (setting the data to null)
        data = null;
        next = null;
        previous = null;
    }


    public int compareTo(Node<PlanarShape> n){//utilises the compareTo method in PlanarShape and reverses the answer as we have to call the method from the opposite variable than normal

        int i = n.data.compareTo((PlanarShape) data);
        if (i==1){
            return -1;
        }else {
            return 1;
        }
    }


    @Override
    public String toString() {//how to convert the object to a string
        String out = "";
        out += data;
        return out;
    }

}
