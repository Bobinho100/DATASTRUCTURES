package main.java.mylib.datastructures.Linear;


import main.java.mylib.datastructures.nodes.DNode;

import static org.junit.Assert.*;

import org.junit.Test;

public class CDLLTest {
    @Test
    public void testInsertHead(){
        CDLL<Integer> list = new CDLL<>();
        list.insertHead(new DNode<>(7));
        assertEquals("List should be 1 after inserting the head", 1, list.getSize());
        assertEquals("List should be 1 after inserting the head", 7,(int) list.getHead().data);


        
        list.insertHead(new DNode<>(17));
        assertEquals("List should be 1 after inserting the head", 2, list.getSize());
        assertEquals("List should be 1 after inserting the head", 17,(int) list.getHead().data);

    }
    @Test
    public void testInserttail(){
        CDLL<Integer> list = new CDLL<>();
        list.insertTail(new DNode<>(10));
        assertEquals("List should be 1 after inserting the tail", 1, list.getSize());
        assertEquals("List should be 1 after inserting the tail", 10,(int) list.getTail().data);


        list.insertTail(new DNode<>(17));
        assertEquals("List should be 1 after inserting the tail", 2, list.getSize());
        assertEquals("List should be 1 after inserting the tail", 17,(int) list.getTail().data);

    }

    @Test
    public void testInsert(){
        CDLL<Integer> list = new CDLL<>();
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
    public void testDeleteHead(){

        CDLL<Integer> list = new CDLL<Integer>();
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

      


    }

    @Test
    public void testDeleteTail(){
        CDLL<Integer> list = new CDLL<Integer>();
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
        CDLL<Integer> list = new CDLL<>();

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
        CDLL<Integer> list = new CDLL<>();

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

    
    




    

    
}
