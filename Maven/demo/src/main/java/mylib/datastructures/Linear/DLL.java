package mylib.datastructures.Linear;
import mylib.datastructures.nodes.DNode;

public class DLL<T extends Comparable<T>>{
    private DNode<T> head;
    private DNode<T> tail;
    private int size;

    public DLL(){
        this.head = null;
        this.tail = head;
        this.size = 0;

    }
    public DLL(DNode<T> head){
        this.head = head;
        this.tail = head;

    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public DNode<T> getHead(){
        return this.head;
    }
    public DNode<T> getTail(){
        return this.tail;
    }
    public void setHead(DNode<T> head){
        this.head = head;
    }
    public void setTail(DNode<T> tail){
        this.tail = tail;
    }

    public void insertHead(DNode<T> node){
        if(head == null || tail == null){
            head = tail = node;
        }else{
            node.next = head;
            head.previous = node;
            head = node;
            
           

        }
        size++;
    }
    public void insertTail(DNode<T> node){
        if(head == null || tail == null){
            head = tail = node;
        }else{
            node.previous = tail;
            tail.next= node;
            tail = node;
        }
        size++;
    }
    public void insert(DNode<T> node, int position){
        DNode<T> current;
        current = head;
        if(position < 0){
            insertHead(node);
            return;
        }else if(position >= size){
            insertTail(node);
            return;
        }else{
            for(int i =0; i < position; i++){
                current = current.next;

            }
            DNode<T> newNode = current.next;
            current.next = node;
            node.previous = current;
            node.next = newNode;
            newNode.previous = node;
            size++;

        }
    }
    public void sortedInsert(DNode<T> node) {
        if (!isSorted()) {
            sort();
        }
        
        if (head == null) {
            insertHead(node);
            return;
        }
        
        DNode<T> current = head;
        while (current != null && ((Comparable<T>) current.data).compareTo(node.data) < 0) {
            current = current.next;
        }
        
        if (current == null) {
            insertTail(node);
        } else {
            DNode<T> previous = current.previous;
            previous.next = node;
            node.previous = previous;
            node.next = current;
            current.previous = node;
            size++;
        }
    }
    
    public boolean isSorted() {
        if (head == null || head.next == null) {
            return true;
        }
        
        DNode<T> current = head;
        while (current.next != null) {
            if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
                return false;
            }
            current = current.next;
        }
        
        return true;
    }
    public T search(DNode<T> node) {
        DNode<T> current = head;
        while (current != null) {
            if (node.data == null && current.data == null) {
                return current.data;
            }
            if (node.data != null && node.data.equals(current.data)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
    

    public void deleteHead(){
        if (head != null){
            head = head.next;
            size--;
            if(head == null){
                tail = null;
            }
        }
    }
    public void deleteTail() {
        if (tail != null) {
            if (tail.previous != null) {
                tail.previous.next = null;
                tail = tail.previous;
            } else {
                // The list has only one node
                head = tail = null;
            }
            size--;
        }
    }
    public void delete(DNode<T> node){
        DNode<T> current = head;
        while (current != null){
            if (current == node){
                // node found, delete it
                if (current == head){
                    // node is head, delete head
                    deleteHead();
                }else if (current == tail){
                    // node is tail, delete tail
                    deleteTail();
                }else{
                    // node is somewhere in the middle
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    size--;
                }
                break;
            }
            current = current.next;
        }
    }
    public void sort() {
        if (head == null || head == tail) {
            return;
        }
    
        DNode<T> current = head.next;
    
        while (current != null) {
            DNode<T> temp = current;
            while (temp.previous != null && ((Comparable<T>) temp.data).compareTo(temp.previous.data) < 0) {
                // swap nodes
                DNode<T> prev = temp.previous;
                DNode<T> next = temp.next;
    
                prev.next = next;
                temp.previous = prev.previous;
                temp.next = prev;
    
                if (prev == head) {
                    head = temp;
                } else {
                    prev.previous.next = temp;
                }
    
                prev.previous = temp;
                if (next != null) {
                    next.previous = prev;
                }
    
                temp = prev;
            }
    
            current = current.next;
        }
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "not sorted"));
        System.out.print("List content: ");
    
        DNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /*
     * Other features not listed in the list
     */

     public int indexOf(T data) {
        DNode<T> current = head;
        int index = 0;
    
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
    
        return -1; // data not found in list
    }

    public void reverse() {
        DNode<T> current = head;
        DNode<T> temp = null;
        
        while (current != null) {
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }
        
        if (temp != null) {
            head = temp.previous;
        }
    }

    public void remove(DNode<T> node) {
        DNode<T> current = head;
        while (current != null) {
            if (current == node) {
                if (current == head) {
                    deleteHead();
                } else if (current == tail) {
                    deleteTail();
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    size--;
                }
                return;
            }
            current = current.next;
        }
    }
    
    
    
    
    

    

    

    
   
    
   
    

    
}
