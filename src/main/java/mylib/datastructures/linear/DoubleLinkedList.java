package main.java.mylib.datastructures.linear;

class DNode<T> extends Node<T> {
    DNode<T> prev;
    public DNode(T data){
        super(data);
        this.prev = null;
    }
    public DNode(T data, DNode<T> prev, Node<T> next){
        super(data, next);
        this.prev = prev;
    }

}







public class DoubleLinkedList<T extends Comparable<T>> extends LinkedList<T>{
    private Node<T> tail;


    public DoubleLinkedList(){
        super();
        this.tail = null;
    }
    public DoubleLinkedList(Node<T> head){

        super(head);
        this.tail = head;
    }

    public void insertHead(DNode<T> node){
        if()

    }
    

    
}
