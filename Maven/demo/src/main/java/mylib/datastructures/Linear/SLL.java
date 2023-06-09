package mylib.datastructures.Linear;
import mylib.datastructures.nodes.DNode;
//mport main.java.mylib.datastructures.nodes.

/*class DNode<T>{
    T data;
    DNode<T> next;

    public DNode(T data){
        this.data = data;
        this.next = null;
    }
    public DNode(T data, DNode<T> next) {
        this.data = data;
        this.next = next;
    }
    
}*/



public class SLL <T extends Comparable<T>>{
    private DNode<T> head;
    private DNode<T> tail;
    private int size;
    /**
     * Constructors
     */
    public SLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;


    }
    public SLL(DNode<T> head){
        this.head = head;
        this.tail = head;
        this.size = 1;
    }
    /*
     * Getters and setters
     */
    public DNode<T> getHead(){
        return this.head;

    }
    public DNode<T> getTail(){
        return this.tail;
    }
    public int getSize(){
        return this.size;
    }
    public void setHead(DNode<T> head){
        this.head = head;
    }
    public void setSize(int size){
        this.size = size;
    }
    public void setTail(DNode<T> tail){
        this.tail = tail;
    }

    /*
     * Public methods
     */


    public void insertHead(DNode<T> node){
        if(head == null){
            head = node;
            tail = node;

        }else{
            node.next = head;
            head = node;

        }
        size++;

    }
    public void insertTail(DNode<T> node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        size++;

    }

    public void insert(DNode<T> node, int position){

        DNode<T> temp;
        temp = head;
        if (position <= 0){
            insertHead(node);
        }
        else if (position >= size){
            insertTail(node);
        }
        

        else{
            for(int i = 0; i < position -1 ; i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
    

        }
    }

    public boolean isEmpty(){
        if(head == null || tail == null){
            return true;
        }
        return false;
    }
    


    public void sortedInsert(DNode<T> node){
        if (head == null) { // List is empty, insert at head
            head = node;
            tail = node;
            size++;
            return;
        }
        
        // Check if list is sorted, sort it if not
        if (!isSorted()) {
            sort();
        }
        
        // Find position to insert node
        DNode<T> current = head;
        DNode<T> previous = null;
        while (current != null && node.data.compareTo(current.data) > 0) {
            previous = current;
            current = current.next;
        }
        
        // Insert node
        if (previous == null) { // Insert at head
            node.next = head;
            head = node;
        } else if (current == null) { // Insert at tail
            previous.next = node;
            tail = node;
        } else { // Insert in middle
            previous.next = node;
            node.next = current;
        }
        
        size++;

    }

    public boolean isSorted() {
        if (head == null || head.next == null) {
            return true;
        }
        DNode<T> current = head;
        while (current.next != null) {
            if (current.data.compareTo(current.next.data) > 0) {
                return false;
            }
            current = current.next;
        }
        return true;
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


    public void deleteTail(){
        if(tail != null){
            if(head == tail){
                head = tail = null;
            }else {
                DNode<T> temp= head;
                while (temp.next != tail){
                    temp = temp.next;

                }
                temp.next = null;
                tail = temp;
            }
        }
        size--;
    }
    public void delete(DNode<T> node) {
        if (head == null) {
            return;
        }
        if (head == node) {
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return;
        }
        DNode<T> temp = head;
        while (temp.next != null) {
            if (temp.next == node) {
                temp.next = node.next;
                size--;
                if (node == tail) {
                    tail = temp;
                }
                return;
            }
            temp = temp.next;
        }
    }

    public void sort() {
        if (head == null || head.next == null) {
            return; // already sorted
        }
    
        DNode<T> sortedHead = head;
        DNode<T> unsorted = head.next;
    
        sortedHead.next = null; // the sorted list only contains the head node
    
        while (unsorted != null) {
            DNode<T> current = unsorted;
            unsorted = unsorted.next;
    
            // Find the position to insert the current node in the sorted list
            DNode<T> prev = null;
            DNode<T> temp = sortedHead;
            while (temp != null && current.data.compareTo(temp.data) > 0) {
                prev = temp;
                temp = temp.next;
            }
    
            // Insert the current node in the sorted list
            if (prev == null) {
                current.next = sortedHead;
                sortedHead = current;
            } else {
                prev.next = current;
                current.next = temp;
            }
        }
    
        head = sortedHead;
        // Update the tail of the list
        DNode<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }
    public void Clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public DNode<T> search(DNode<T> node) {
        DNode<T> current = head;
        while (current != null) {
            if (current.equals(node)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void print() {
        System.out.println("List length: " + size);
    
        if (isSorted()) {
            System.out.println("Sorted: Yes");
        } else {
            System.out.println("Sorted: No");
        }
    
        System.out.print("List content: ");
        DNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    
    
   
    
    

    
    

    


    
    
}


  





 


