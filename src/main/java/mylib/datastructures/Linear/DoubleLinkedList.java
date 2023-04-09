package main.java.mylib.datastructures.Linear;

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







public class DoubleLinkedList<T extends Comparable<T>> extends SLL<T>{
    private Node<T> tail;
    private DNode<T> head;


    public DoubleLinkedList(){
        super();
        this.tail = null;
        this.head = null;
    }
    public DoubleLinkedList(Node<T> head){

        super(head);
        this.head = head;
        this.tail = head;
    }

    public void insertHead(DNode<T> node){
        node.setNext(this.head);
        if(this.head != null){
            ((DNode<T>)this.head).prev = node;
        }else{
            this.tail = node;
        }
        this.head = node;
        this.size++;
        
    

    }
    

    
}
