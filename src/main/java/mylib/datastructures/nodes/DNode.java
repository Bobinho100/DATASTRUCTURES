package main.java.mylib.datastructures.nodes;

public class DNode<T> {
    public T data;
    public DNode<T> next;
    public DNode<T> previous;
    

    public DNode(T data){
        this.data = data;
        this.next = null;
        this.previous = null;

    }
    public DNode(){

    }
    
}
