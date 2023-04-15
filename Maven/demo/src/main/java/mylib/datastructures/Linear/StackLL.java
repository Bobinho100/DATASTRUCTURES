package mylib.datastructures.Linear;
//import main.java.mylib.datastructures.DNodes.DDNode;
import mylib.datastructures.nodes.DNode;

public class StackLL<T extends Comparable<T>>  extends SLL<T>{ 

    public StackLL(){
        super();
    }
    @Override
    public void insertTail(DNode<T> DNode){}
    public void deleteTail(){}


    
    public void push(DNode<T> DNode){
        super.insertHead(DNode);
    
    }
    public void Insert(DNode<T> DNode, int position){}
    public void SortedInsert(DNode<T> DNode){}
    public void delete(DNode<T> DNode){}

    public DNode<T> peek(){
        return super.getHead();
    }
    public void pop(){
        super.deleteHead();
    }
    public int size(){
        return this.getSize();
    }
    public DNode<T> search(T data) {
        DNode<T> current = getHead();
        while (current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    




    
}
