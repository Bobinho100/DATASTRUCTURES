package main.java.mylib.datastructures.Linear;
import main.java.mylib.datastructures.nodes.Node;;

public class QueueLL<T extends Comparable<T>>  extends SLL<T> {

    public QueueLL(){
        super();
    }

    public void enqueue(Node<T> node){
        super.insertTail(node);
    }
    public void dequeue(){
        super.deleteHead();
    }

    public Node<T> peek(){
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
    
    public void insertHead(Node<T> node){}

    public void delete(Node<T> node){}
    
}
