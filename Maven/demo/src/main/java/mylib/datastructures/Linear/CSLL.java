package mylib.datastructures.Linear;

import mylib.datastructures.nodes.DNode;

public class CSLL<T extends Comparable<T>>  extends SLL<T> {
    

    public CSLL(){
        super();
        
    }
   
    public CSLL(DNode<T> head){
        super(head);
        head = head.next;
        
        
        

    }
    public void makeCircular(){
        
    }
    @Override
    public void insertHead(DNode<T> DNode){
        if(this.getHead() == null){
            super.insertHead(DNode);
            DNode.next = DNode;
            


        }else{
            DNode.next = this.getHead();
            this.getTail().next = DNode;
            super.insertHead(DNode);
        }
        

    }
    @Override

    public void insertTail(DNode<T> DNode){
        if(this.getHead()  == null){
            super.insertTail(DNode);
            DNode.next = DNode;

        }else {
            DNode.next = this.getHead();
            this.getTail().next = DNode;
            super.insertTail(DNode);
        }
        //this.setSize(this.getSize() + 1);

    }
    public void insert(DNode<T> DNode, int position){
        if (position < 0 || position > this.getSize()){
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0){
            insertHead(DNode);
        }else if(position == this.getSize()){
            insertTail(DNode);
        }else {
            DNode<T> current = this.getHead();
            for(int i = 0; i < position -1 ;i++){
                current = current.next;
            }
            DNode.next = current.next;
            current.next = DNode;
            this.setSize(getSize() + 1);
        }
        
    }









    /*@Override
    public void deleteHead(){
        if(this.getHead() != null){
            if (this.getHead() == this.getTail()) {
                this.setTail(null);
            }
        }
        super.deleteHead();
        
    }*/

    public void deleteHead(){
        if (this.getHead() != null){
            if (this.getHead() == this.getTail()) {
                setHead(null) ;
                setTail(null);
                //this.getHead() = null;
                //this.setTail(null);
                //this.getTail() = null;
            } else {
                setHead(getHead().next);
                
                //this.getHead() = head.next;
                this.getTail().next = this.getHead();
                //tail.next = head;
            }
            setSize(getSize() - 1);
            //size--;
        }
    }
    @Override
    public void deleteTail(){
        if(this.getHead() != null && this.getTail() != null){
            DNode<T> current = this.getHead();
            while(current.next != this.getTail()){
                current = current.next;
            }
            current.next = this.getHead();

        }
        super.deleteTail();
        this.setSize(getSize()-1);
    }

    public void sortedInsert(DNode<T> DNode) {
        if (DNode == null) {
            return;
        }
    
        // Check if list is sorted
        if (!isSorted()) {
            sort();
        }
    
        // Special case if list is empty
        if (this.getHead() == null) {
            this.insertHead(DNode);
            return;
        }else if (this.getHead().data.compareTo(DNode.data) >= 0) {
            super.insertHead(DNode);
        } else {
            DNode<T> current = this.getHead();
            while (current.next != null && current.next.data.compareTo(DNode.data) < 0) {
                current = current.next;
            }
            DNode.next = current.next;
            current.next = DNode;
            this.setSize(this.getSize() + 1);
        }
        

    
        
    }
    public boolean isSorted() {
        DNode<T> current = getHead();
        while (current.next != getHead()) {
            if (current.data.compareTo(current.next.data) > 0) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
    public DNode<T> search(DNode<T> DNode) {
        DNode<T> curr = this.getHead();
        while (curr != null) {
            if (curr.equals(DNode)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public void delete(DNode<T> DNode) {
        if (this.getHead() == null) {
            return;
        }
        
        if (DNode == this.getHead()) {
            this.deleteHead();
            return;
        }
        
        DNode<T> curr = this.getHead();
        while (curr.next != this.getHead() && curr.next != DNode) {
            curr = curr.next;
        }
        
        if (curr.next == DNode) {
            curr.next = DNode.next;
            DNode.next = null;
            this.setSize(this.getSize() - 1);
        }
    }

    public void sort() {
        if (this.getHead() == null) {
            return;
        }
        
        DNode<T> curr = this.getHead().next;
        while (curr != null) {
            DNode<T> temp = curr.next;
            sortedInsert(curr);
            curr = temp;
        }
    }
    public void clear() {
        if (this.getHead() == null) {
            return;
        }
        DNode<T> curr = this.getHead();
        while (curr.next!= null) {
            DNode<T> temp = curr;
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
        DNode<T> curr = this.getHead();
        System.out.print("List content: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

 
    
    

    

    
    

   
    
    

    
    


    
    
}
