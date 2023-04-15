package test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

import org.junit.Test;

import mylib.datastructures.Linear.CSLL;
import mylib.datastructures.Linear.SLL;
import mylib.datastructures.nodes.DNode;

public class CSLLTest {

    @Test
    public void testInsertHead(){
        CSLL<Integer> list = new CSLL<>();
        list.insertHead(new DNode<Integer>(10));
        list.insertHead(new DNode<Integer>(9));
        list.insertHead(new DNode<Integer>(8));

        assertEquals(3, list.getSize());
        assertEquals(8, (int) list.getHead().data);
        assertEquals(10,(int) list.getTail().data);


    }
    @Test
    public void testInsertTail(){

        CSLL<Integer> list = new CSLL<>();
        list.insertTail(new DNode<Integer>(10));
        list.insertTail(new DNode<Integer>(9));
        list.insertTail(new DNode<Integer>(8));

        assertEquals(3, list.getSize());
        assertEquals(10, (int) list.getHead().data);
        assertEquals(8,(int) list.getTail().data);

    }
    @Test
    public void testInsert(){
        CSLL<Integer> list = new CSLL<Integer>();
        list.insert(new DNode<Integer>(1), 0);
        assertEquals(1, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(1,(int) list.getTail().data);

        list.insert(new DNode<Integer>(3), 1);
        assertEquals(2, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(3,(int) list.getTail().data);


        list.insert(new DNode<Integer>(2), 1);
        assertEquals(3, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(3,(int) list.getTail().data);

    }

    @Test
    public void testDeleteHead(){

        CSLL<Integer> list = new CSLL<Integer>();
        list.insertHead(new DNode<Integer>(1));
        list.insertHead(new DNode<Integer>(2));
        list.insertHead(new DNode<Integer>(3));

        list.deleteHead();
        System.out.println("Head DNode value after deleting all DNodes: " + list.getHead().data);
        assertEquals(2, list.getSize());
        //assertEquals(2,(int)list.getHead().data);
        assertEquals(1,(int) list.getTail().data);

        list.deleteHead();
        System.out.println("Head DNode value after deleting all DNodes: " + list.getHead().next.data);
        assertEquals(1,list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(1, (int) list.getTail().data);

        list.deleteHead();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());

      



    }
    @Test
    public void testDeletetail(){

        CSLL<Integer> list = new CSLL<>();
        list.insert(new DNode<Integer>(1), 0);
        assertEquals(1, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(1,(int) list.getTail().data);

        list.insert(new DNode<Integer>(3), 1);
        assertEquals(2, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(3,(int) list.getTail().data);


        list.insert(new DNode<Integer>(2), 1);
        assertEquals(3, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(3,(int) list.getTail().data);

    }

    @Test
    public void testIsSorted(){
        CSLL<Integer> list = new CSLL<>();

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
    public void testDeleteDNode(){
        CSLL<Integer> list = new CSLL<>();

        list.insert(new DNode<Integer>(1), 0);
        list.insert(new DNode<Integer>(2), 1);
        list.insert(new DNode<Integer>(3), 2);
        list.insert(new DNode<Integer>(4), 3);

        DNode<Integer> new_DNode = list.getHead();

        list.delete(new_DNode);
        assertFalse(list.getHead() == new_DNode);
        assertEquals(3, list.getSize());

        
        
        list.insert(new DNode<Integer>(10), 0);
        list.insert(new DNode<Integer>(2), 1);
        list.insert(new DNode<Integer>(15), 2);
        list.insert(new DNode<Integer>(4), 3);


        assertFalse(list.isSorted());


    }
    @Test
    public void testIsSort(){
        SLL<Integer> list = new SLL<>();

        list.insert(new DNode<Integer>(10), 0);
        list.insert(new DNode<Integer>(5), 1);
        list.insert(new DNode<Integer>(2), 2);
        list.insert(new DNode<Integer>(7), 3);
        list.sort();

        assertTrue(list.isSorted());

    }

}
