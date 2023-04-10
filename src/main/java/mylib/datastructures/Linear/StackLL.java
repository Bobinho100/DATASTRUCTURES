package main.java.mylib.datastructures.Linear;
import main.java.mylib.datastructures.nodes.DNode;
import main.java.mylib.datastructures.nodes.Node;;

public class StackLL<T extends Comparable<T>>  extends SLL<T>{ 

    public StackLL(){
        super();
    }
    @Override
    public void insertTail(Node<T> node){}
    public void deleteTail(){}


    
    public void push(Node<T> node){
        super.insertHead(node);
    
    }
    public void Insert(Node<T> node, int position){}
    public void SortedInsert(Node<T> node){}
    public void delete(Node<T> node){}

    public Node<T> peek(){
        return super.getHead();
    }
    public void pop(){
        super.deleteHead();
    }
    public int size(){
        return this.getSize();
    }
    public Node<T> search(T data) {
        Node<T> current = getHead();
        while (current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    




    
}
