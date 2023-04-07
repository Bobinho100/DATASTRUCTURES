package main.java.mylib.datastructures.Linear;

class Node<T>{
    T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }
}



public class SLL <T extends Comparable<T>>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;


    }
    public SLL(Node<T> head){
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    public void insertHead(Node<T> node){
        if(head == null){
            head = node;
            tail = node;

        }else{
            node.next = head;
            head = node;

        }
        size++;

    }
    public void insertTail(Node<T> node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }

    }

    public void insert(Node<T> node, int position){

        Node<T> temp;
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
    


    public void sortedInsert(Node<T> node){

    }

    public boolean isSorted() {
        if (head == null || head.next == null) {
            return true;
        }
        Node<T> current = head;
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
                Node<T> temp= head;
                while (temp.next != tail){
                    temp = temp.next;

                }
                temp.next = null;
                tail = temp;
            }
        }
        size--;
    }
    public void delete(Node<T> node) {
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
        Node<T> temp = head;
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
    
        Node<T> sortedHead = head;
        Node<T> unsorted = head.next;
    
        sortedHead.next = null; // the sorted list only contains the head node
    
        while (unsorted != null) {
            Node<T> current = unsorted;
            unsorted = unsorted.next;
    
            // Find the position to insert the current node in the sorted list
            Node<T> prev = null;
            Node<T> temp = sortedHead;
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
        Node<T> temp = head;
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

    public void print() {
        System.out.println("List length: " + size);
    
        if (isSorted()) {
            System.out.println("Sorted: Yes");
        } else {
            System.out.println("Sorted: No");
        }
    
        System.out.print("List content: ");
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    
    
   
    
    

    
    

    


    
    
}


  





 


