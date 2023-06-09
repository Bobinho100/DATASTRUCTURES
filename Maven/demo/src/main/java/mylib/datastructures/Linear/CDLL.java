package mylib.datastructures.Linear;
import mylib.datastructures.nodes.DNode;

public class CDLL<T extends Comparable<T>>  extends DLL<T>{
    public CDLL(){
        super();

    }
    public CDLL(DNode<T> head) {
        super(head);
        if (head != null) {
            head.previous = this.getTail();
            this.getTail().next = head;
            
        }
    }
    @Override
    public void insertHead(DNode<T> node) {
        if (this.getHead() == null) {
            super.insertHead(node);
            node.next = node;
            node.previous = node;
            
        } else {
            node.next = this.getHead();
            node.previous = this.getTail();
            this.getHead().previous = node;
            this.getTail().next = node;
            super.insertHead(node);
        }
    }

    public void insertTail(DNode<T> node) {
        if (this.getHead() == null) {
            super.insertTail(node);
            node.next = node;
            node.previous = node;
            
        } else {
            node.next = this.getHead();
            node.previous = this.getTail();

            this.getHead().previous = node;
            this.getTail().next = node;
            super.insertTail(node);
        }
    }
    //@Override
    /*public void deleteHead() {
        if (this.getHead() != null && this.getTail() != null) {
            this.getHead().next.previous = this.getTail();
            this.getTail().next = this.getHead().next;
            
        }
        super.deleteHead();
    }*/

    public void deleteHead() {
        if (this.getHead() != null) {  // check if the list is not empty
            setHead(getHead().next);
            //this.getHead() = this.head.next;  // update the head node
            if (this.getHead() != null) {
                this.getHead().previous = this.getTail();  // update the previous node of the new head node
                this.getTail().next = this.getHead();  // update the next node of the tail node
            } else {
                setHead(null);
                setTail(null);
                //this.getTail() = null;  // if the list is now empty, set the tail to null
            }
            setSize(getSize() - 1);
            //this.size--;  // decrement the size of the list
        }
    }

    /*@Override
    public void deleteTail() {
        if (this.getHead() != null && this.getTail() != null) {
            this.getTail().previous.next = this.getHead();
            this.getHead().previous = this.getTail().previous;
            
        }
        super.deleteTail();
    }*/
  
    /*public void deleteTail() {
        if (this.getHead() != null && this.getTail() != null) {
            if (this.getHead() == this.getTail()) { // if there is only one node in the list
                this.setHead(null);
                this.setTail(null);
            } else {
                DNode<T> newTail = this.getTail().previous;
                newTail.next = this.getHead();
                this.getHead().previous = newTail;
                this.setTail(newTail);
            }
            super.deleteTail();
        }
    }  */


public void deleteTail() {
    if (getHead() == null || getTail() == null) {
        return; // list is empty
    }
    
    if (getHead() == getTail()) { // if there is only one node in the list
        setHead(null);
        setTail(null);
    } else {
        DNode<T> newTail = getTail().previous;
        newTail.next = getHead();
        getHead().previous = newTail;
        setTail(newTail);
    }
    
    setSize(getSize() - 1);
}
    public void Insert(DNode<T> node, int position) {
        if (position < 1 || position > getSize() + 1) {
            System.out.println("Invalid position. Insertion failed.");
            return;
        }
    
        if (position == 1) {
            super.insertHead(node);
            return;
        }
        if(position == getSize() + 1){
            insertTail(node);
            return;

        }
    
        DNode<T> current = getHead();
        int count = 1;

        while (count < position - 1) {
            current = current.next;
            count++;
        }
    
        DNode<T> next = current.next;
        node.next = next;
        next.previous = node;
        current.next = node;
        node.previous = current;
        
        this.setSize(getSize()+1);
    
    }
    public void SortedInsert(DNode<T> node) {
        if (node == null) {
            return;
        }
        
        if (!isSorted()) {
            sort();
        }
        
        DNode<T> current = getHead();
        
        while (current.next != getHead() && node.data.compareTo(current.next.data) > 0) {
            current = current.next;
        }
        
        node.next = current.next;
        current.next.previous = node;
        current.next = node;
        node.previous = current;
        
        this.setSize(getSize()+ 1);
    }

    
    
    public boolean isSorted() {
        DNode<T> current = getHead();
        boolean sorted = true;
        
        while (current.next != getHead()) {
            if (current.data.compareTo(current.next.data) > 0) {
                sorted = false;
                break;
            }
            
            current = current.next;
        }
        
        return sorted;
    }
    
    public T search(DNode<T> node) {
        if (node == null || getHead() == null) {
            return null;
        }
        DNode<T> curr = getHead();
        do {
            if (node.equals(curr)) {
                return curr.data;
            }
            curr = curr.next;
        } while (curr != getHead());
        return null;
    }
    public void Delete(DNode<T> node) {
        if (node == null) {
            return;
        }
        if (node == getHead() && getHead() != null) {
            setHead(getHead().next);
            if (getHead() != null) {
                getHead().previous = getTail();
            }
            getTail().next = getHead();
            this.setSize(getSize()-1);
        } else {
            DNode<T> curr = getHead();
            boolean found = false;
            while (curr != null) {
                if (curr == node) {
                    found = true;
                    break;
                }
                curr = curr.next;
            }
            if (found) {
                curr.previous.next = curr.next;
                curr.next.previous = curr.previous;

                this.setSize(getSize()-1);

            }
        }
    }
    public void sort() {
        if (getSize() <= 1) {
            return; // list is already sorted or empty
        }
        DNode<T> current = getHead().next; // start from the second node
        while (current != getHead()) { // loop through all nodes
            DNode<T> next = current.next; // remember the next node
            sortedInsert(current); // insert current node in sorted order
            current = next; // move to the next node
        }
    }
    public void clear() {
        if (getHead() == null) {
            // list is already empty
            return;
        }
        DNode<T> current = getHead();
        DNode<T> next;
        while (current != getTail()) {
            next = current.next;
            current.next = null;
            current.previous = null;
            
            current = next;
        }
        getTail().next = null;
        getTail().previous = null;
        setHead(null);
        setTail(null);
        setSize(0);
        
    }

    public void print() {
        System.out.println("List length: " + getSize());
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "unsorted"));
        System.out.print("List content: ");
        if (getSize() == 0) {
            System.out.println("empty");
        } else {
            DNode<T> curr = getHead();
            for (int i = 0; i < getSize(); i++) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }
    
    
    


    

    
    
}




    

