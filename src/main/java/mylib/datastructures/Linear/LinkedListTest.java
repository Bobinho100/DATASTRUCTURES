package main.java.mylib.datastructures.Linear;
import main.java.mylib.datastructures.nodes.Node;


import org.junit.Test;

import static org.junit.Assert.*;


public class LinkedListTest {

    @Test
    public void testInsertHead() {
        SLL<Integer> list = new SLL<Integer>();
        list.insertHead(new Node<Integer>(1));
        assertEquals(1, list.getSize());
        assertEquals(1, (int) list.getHead().data);
        assertEquals(1,(int) list.getTail().data);

        list.insertHead(new Node<Integer>(2));
        assertEquals(2, list.getSize());
        assertEquals(2,(int) list.getHead().data);
        assertEquals(1,(int) list.getTail().data);

        list.insertHead(new Node<Integer>(3));
        assertEquals(3, list.getSize());
        assertEquals(3,(int) list.getHead().data);
        assertEquals(1,(int) list.getTail().data);
    }
    @Test
    public void testInsertTail(){
        SLL<Integer> list = new SLL<Integer>();
        list.insertTail(new Node<Integer>(1));
        assertEquals(1, list.getSize());
        assertEquals(1, (int) list.getHead().data);
        assertEquals(1, (int) list.getTail().data);

        list.insertTail(new Node<Integer>(2));
        assertEquals(2, list.getSize());
        assertEquals(1, (int) list.getHead().data);
        assertEquals(2, (int) list.getTail().data);

        list.insertTail(new Node<Integer>(3));
        assertEquals(3, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(3,(int) list.getTail().data);
    }
    @Test
    public void testInsert(){
        SLL<Integer> list = new SLL<Integer>();
        list.insert(new Node<Integer>(1), 0);
        assertEquals(1, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(1,(int) list.getTail().data);

        list.insert(new Node<Integer>(3), 1);
        assertEquals(2, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(3,(int) list.getTail().data);


        list.insert(new Node<Integer>(2), 1);
        assertEquals(3, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(3,(int) list.getTail().data);

    }
    @Test
    public void testSortedInsert(){
        SLL<Integer> list = new SLL<Integer>();
        list.sortedInsert(new Node<Integer>(2));
        assertEquals(1, list.getSize());
        assertEquals(2, (int) list.getHead().data);
        assertEquals(2,(int) list.getTail().data);


    
        list.sortedInsert(new Node<Integer>(1));
        assertEquals(2, list.getSize());
        assertEquals(1, (int) list.getHead().data);
        assertEquals(2,(int) list.getTail().data);


        list.sortedInsert(new Node<Integer>(3));
        assertEquals(3, list.getSize());
        assertEquals(1, (int) list.getHead().data);
        assertEquals(3,(int) list.getTail().data);



    }
    @Test
    public void testDeleteHead(){

        SLL<Integer> list = new SLL<Integer>();
        list.insertHead(new Node<Integer>(1));
        list.insertHead(new Node<Integer>(2));
        list.insertHead(new Node<Integer>(3));

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
        SLL<Integer> list = new SLL<Integer>();
        list.insertTail(new Node<Integer>(1));
        list.insertTail(new Node<Integer>(2));
        list.insertTail(new Node<Integer>(3));

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
        SLL<Integer> list = new SLL<>();

        list.insert(new Node<Integer>(1), 0);
        list.insert(new Node<Integer>(2), 1);
        list.insert(new Node<Integer>(3), 2);
        list.insert(new Node<Integer>(4), 3);

        assertTrue(list.isSorted());
        
        list.insert(new Node<Integer>(10), 0);
        list.insert(new Node<Integer>(2), 1);
        list.insert(new Node<Integer>(15), 2);
        list.insert(new Node<Integer>(4), 3);


        assertFalse(list.isSorted());

    }
    @Test
    public void testDeleteNode(){
        SLL<Integer> list = new SLL<>();

        list.insert(new Node<Integer>(1), 0);
        list.insert(new Node<Integer>(2), 1);
        list.insert(new Node<Integer>(3), 2);
        list.insert(new Node<Integer>(4), 3);

        Node<Integer> new_node = list.getHead();

        list.delete(new_node);
        assertFalse(list.getHead() == new_node);
        assertEquals(3, list.getSize());

        
        
        list.insert(new Node<Integer>(10), 0);
        list.insert(new Node<Integer>(2), 1);
        list.insert(new Node<Integer>(15), 2);
        list.insert(new Node<Integer>(4), 3);


        assertFalse(list.isSorted());


    }
    @Test
    public void testIsSort(){
        SLL<Integer> list = new SLL<>();

        list.insert(new Node<Integer>(10), 0);
        list.insert(new Node<Integer>(5), 1);
        list.insert(new Node<Integer>(2), 2);
        list.insert(new Node<Integer>(7), 3);
        list.sort();

        assertTrue(list.isSorted());

    }
    @Test
    public void testPrint(){
        SLL<Integer> list = new SLL<>();

        list.insert(new Node<Integer>(1), 0);
        list.insert(new Node<Integer>(2), 1);
        list.insert(new Node<Integer>(3), 2);
        list.insert(new Node<Integer>(4), 3);

        String expected = "1 -> 2 -> 3 -> 4 ";
        assertEquals(expected, list.print());

    }
}

