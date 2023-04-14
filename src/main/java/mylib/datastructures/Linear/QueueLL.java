package main.java.mylib.datastructures.Linear;
import main.java.mylib.datastructures.nodes.DNode;

public class QueueLL<T extends Comparable<T>>  extends SLL<T> {

    public QueueLL(){
        super();
    }

    public void enqueue(DNode<T> DNode){
        super.insertTail(DNode);
    }
    public void dequeue(){
        super.deleteHead();
    }

    public DNode<T> peek(){
        return super.getHead();

    }
    public void clear(){
        super.Clear();
    }
    public int size(){
        return super.getSize();
    }
    public void print(){
        super.print();
    }
    
    public void insertHead(DNode<T> DNode){}

    public void delete(DNode<T> DNode){}
    
}
