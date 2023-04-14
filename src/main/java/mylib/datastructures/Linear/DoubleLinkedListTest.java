package main.java.mylib.datastructures.Linear;

import org.junit.Test;

import main.java.mylib.datastructures.nodes.DNode;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

    @Test
    public void testInsertHead(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertHead(new DNode<>(7));
        assertEquals("List should be 1 after inserting the head", 1, list.getSize());
        assertEquals("List should be 1 after inserting the head", 7,(int) list.getHead().data);


        
        list.insertHead(new DNode<>(17));
        assertEquals("List should be 1 after inserting the head", 2, list.getSize());
        assertEquals("List should be 1 after inserting the head", 17,(int) list.getHead().data);

    }
    @Test
    public void testInserttail(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertTail(new DNode<>(10));
        assertEquals("List should be 1 after inserting the tail", 1, list.getSize());
        assertEquals("List should be 1 after inserting the tail", 10,(int) list.getTail().data);


        list.insertTail(new DNode<>(17));
        assertEquals("List should be 1 after inserting the tail", 2, list.getSize());
        assertEquals("List should be 1 after inserting the tail", 17,(int) list.getTail().data);

    }
    @Test
    public void testInsert(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(new DNode<Integer>(1), 0);
        assertEquals(1, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(1,(int) list.getTail().data);

        list.insert(new DNode<Integer>(3), 1);
        assertEquals(2, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(3,(int) list.getTail().data);


    }
    @Test
    public void testSortedInsert() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.sortedInsert(new DNode<Integer>(2));
        assertEquals(1, list.getSize());
        assertEquals(2, (int) list.getHead().data);
        assertEquals(2,(int) list.getTail().data);

        list.sortedInsert(new DNode<Integer>(6));
        assertEquals(2, list.getSize());
        assertEquals(2, (int) list.getHead().data);
        assertEquals(6,(int) list.getTail().data);


        list.sortedInsert(new DNode<Integer>(3));
        assertEquals(3, list.getSize());
        assertEquals(2, (int) list.getHead().data);
        assertEquals(6,(int) list.getTail().data);
    }
    @Test
    public void testDeleteHead(){

        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.insertHead(new DNode<Integer>(1));
        list.insertHead(new DNode<Integer>(2));
        list.insertHead(new DNode<Integer>(3));

        list.deleteHead();
        assertEquals(2, list.getSize());
        assertEquals(2,(int)list.getHead().data);
        assertEquals(1,(int) list.getTail().data);

        list.deleteHead();
        assertEquals(1,list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(1, (int) list.getTail().data);

        list.deleteHead();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());



    }
    @Test
    public void testDeleteTail(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.insertTail(new DNode<Integer>(1));
        list.insertTail(new DNode<Integer>(2));
        list.insertTail(new DNode<Integer>(3));

        list.deleteTail();
        assertEquals(2, list.getSize());
        assertEquals(1,(int)list.getHead().data);
        assertEquals(2,(int) list.getTail().data);

        list.deleteTail();
        assertEquals(1, list.getSize());
        assertEquals(1,(int)list.getHead().data);
        assertEquals(1,(int) list.getTail().data);

        list.deleteTail();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());
        



    }
    @Test
    public void testIsSorted(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.insert(new DNode<Integer>(1), 0);
        list.insert(new DNode<Integer>(2), 1);
        list.insert(new DNode<Integer>(3), 2);
        list.insert(new DNode<Integer>(4), 3);

        assertTrue(list.isSorted());
        
        list.insert(new DNode<Integer>(10), 0);
        list.insert(new DNode<Integer>(2), 1);
        list.insert(new DNode<Integer>(15), 2);
        list.insert(new DNode<Integer>(4), 3);


        assertFalse(list.isSorted());

    }
    @Test
    public void testDeleteNode(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.insert(new DNode<Integer>(1), 0);
        list.insert(new DNode<Integer>(2), 1);
        list.insert(new DNode<Integer>(3), 2);
        list.insert(new DNode<Integer>(4), 3);

        DNode<Integer> new_node = list.getHead();

        list.delete(new_node);
        assertFalse(list.getHead() == new_node);
        assertEquals(3, list.getSize());

        
        
        list.insert(new DNode<Integer>(10), 0);
        list.insert(new DNode<Integer>(2), 1);
        list.insert(new DNode<Integer>(15), 2);
        list.insert(new DNode<Integer>(4), 3);


        assertFalse(list.isSorted());


    }
    @Test
    public void testIsSort(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.insert(new DNode<Integer>(10), 0);
        list.insert(new DNode<Integer>(5), 1);
        list.insert(new DNode<Integer>(2), 2);
        list.insert(new DNode<Integer>(7), 3);
        list.sort();

        assertFalse(list.isSorted());

    }
    @Test
    public void testIndexOf(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(new DNode<>(10), 0);
        list.insert(new DNode<>(9), 1);
        list.insert(new DNode<>(8), 2);
        list.insert(new DNode<>(7), 3);

        assertEquals(0, list.indexOf(10));
        assertEquals(-1, list.indexOf(2));
    }
    @Test
    public void testReverse(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(new DNode<>(10), 0);
        list.insert(new DNode<>(9), 1);
        list.insert(new DNode<>(8), 2);
        list.insert(new DNode<>(7), 3);

        list.reverse();
        assertEquals(0,(int) list.indexOf(7));
        assertEquals(1,(int) list.indexOf(8));
        
    }
    @Test
    public void testRemove(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(new DNode<>(10), 0);
        list.insert(new DNode<>(9), 1);
        list.insert(new DNode<>(8), 2);
        list.insert(new DNode<>(7), 3);

        //DNode<Integer> newNode = list.getHead();

        list.remove(list.getHead());
        assertEquals(3, list.getSize());

        assertEquals(9,(int) list.getHead().data);
        
    }


    


    


    
    
}
