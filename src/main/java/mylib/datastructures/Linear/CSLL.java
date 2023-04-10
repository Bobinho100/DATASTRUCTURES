package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.Node;

public class CSLL<T extends Comparable<T>>  extends SLL<T> {
    

    public CSLL(){
        super();
        
    }
   
    public CSLL(Node<T> head){
        super(head);
        head = head.next;
        
        
        

    }
    public void makeCircular(){
        
    }
    @Override
    public void insertHead(Node<T> node){
        if(this.getHead() == null){
            super.insertHead(node);
            node.next = node;
            


        }else{
            node.next = this.getHead();
            this.getTail().next = node;
            super.insertHead(node);
        }
        this.setSize(this.getSize() + 1);

    }
    @Override

    public void insertTail(Node<T> node){
        if(this.getHead()  == null){
            super.insertTail(node);
            node.next = node;

        }else {
            node.next = this.getHead();
            this.getTail().next = node;
            super.insertTail(node);
        }
        this.setSize(this.getSize() + 1);

    }
    public void insert(Node<T> node, int position){
        if (position < 0 || position > this.getSize()){
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0){
            insertHead(node);
        }else if(position == this.getSize()){
            insertTail(node);
        }else {
            Node<T> current = this.getHead();
            for(int i = 0; i < position -1 ;i++){
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            this.setSize(getSize() + 1);
        }
        
    }









    @Override
    public void deleteHead(){
        if(this.getHead() != null && this.getTail() != null){
            this.getTail().next = this.getHead().next;
        }
        super.deleteHead();
        this.setSize(getSize() - 1);
    }
    @Override
    public void deleteTail(){
        if(this.getHead() != null && this.getTail() != null){
            Node<T> current = this.getHead();
            while(current.next != this.getTail()){
                current = current.next;
            }
            current.next = this.getHead();

        }
        super.deleteTail();
        this.setSize(getSize()-1);
    }

    public void sortedInsert(Node<T> node) {
        if (node == null) {
            return;
        }
    
        // Check if list is sorted
        if (!isSorted()) {
            sort();
        }
    
        // Special case if list is empty
        if (this.getHead() == null) {
            this.insertHead(node);
            return;
        }else if (this.getHead().data.compareTo(node.data) >= 0) {
            super.insertHead(node);
        } else {
            Node<T> current = this.getHead();
            while (current.next != null && current.next.data.compareTo(node.data) < 0) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            this.setSize(this.getSize() + 1);
        }
        

    
        
    }
    public boolean isSorted() {
        Node<T> current = getHead();
        while (current.next != getHead()) {
            if (current.data.compareTo(current.next.data) > 0) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
    public Node<T> search(Node<T> node) {
        Node<T> curr = this.getHead();
        while (curr != null) {
            if (curr.equals(node)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public void delete(Node<T> node) {
        if (this.getHead() == null) {
            return;
        }
        
        if (node == this.getHead()) {
            this.deleteHead();
            return;
        }
        
        Node<T> curr = this.getHead();
        while (curr.next != this.getHead() && curr.next != node) {
            curr = curr.next;
        }
        
        if (curr.next == node) {
            curr.next = node.next;
            node.next = null;
            this.setSize(this.getSize() - 1);
        }
    }

    public void sort() {
        if (this.getHead() == null) {
            return;
        }
        
        Node<T> curr = this.getHead().next;
        while (curr != null) {
            Node<T> temp = curr.next;
            sortedInsert(curr);
            curr = temp;
        }
    }
    public void clear() {
        if (this.getHead() == null) {
            return;
        }
        Node<T> curr = this.getHead();
        while (curr.next!= null) {
            Node<T> temp = curr;
            curr = curr.next;
            temp.next = null;
        }
        this.setHead(null);
        this.setTail(null);
        this.setSize(0);
    }

    public void print() {
        // Print the list length
        System.out.println("List length: " + this.getSize());
    
        // Check if the list is sorted
        boolean sorted = this.isSorted();
        if (sorted) {
            System.out.println("List is sorted");
        } else {
            System.out.println("List is not sorted");
        }
    
        // Print the list content
        Node<T> curr = this.getHead();
        System.out.print("List content: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    
    
    
    

    

    
    

   
    
    

    
    


    
    
}
