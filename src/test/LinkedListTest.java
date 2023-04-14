package test;
import main.java.mylib.datastructures.Linear.SLL;
import main.java.mylib.datastructures.nodes.DNode;


import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class LinkedListTest {

    @Test
    public void testInsertHead() {
        SLL<Integer> list = new SLL<Integer>();
        list.insertHead(new DNode<Integer>(1));
        assertEquals(1, list.getSize());
        assertEquals(1, (int) list.getHead().data);
        assertEquals(1,(int) list.getTail().data);

        list.insertHead(new DNode<Integer>(2));
        assertEquals(2, list.getSize());
        assertEquals(2,(int) list.getHead().data);
        assertEquals(1,(int) list.getTail().data);

        list.insertHead(new DNode<Integer>(3));
        assertEquals(3, list.getSize());
        assertEquals(3,(int) list.getHead().data);
        assertEquals(1,(int) list.getTail().data);
    }
    @Test
    public void testInsertTail(){
        SLL<Integer> list = new SLL<Integer>();
        list.insertTail(new DNode<Integer>(1));
        assertEquals(1, list.getSize());
        assertEquals(1, (int) list.getHead().data);
        assertEquals(1, (int) list.getTail().data);

        list.insertTail(new DNode<Integer>(2));
        assertEquals(2, list.getSize());
        assertEquals(1, (int) list.getHead().data);
        assertEquals(2, (int) list.getTail().data);

        list.insertTail(new DNode<Integer>(3));
        assertEquals(3, list.getSize());
        assertEquals(1,(int) list.getHead().data);
        assertEquals(3,(int) list.getTail().data);
    }
    @Test
    public void testInsert(){
        SLL<Integer> list = new SLL<Integer>();
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
    public void testSortedInsert(){
        SLL<Integer> list = new SLL<Integer>();
        list.sortedInsert(new DNode<Integer>(2));
        assertEquals(1, list.getSize());
        assertEquals(2, (int) list.getHead().data);
        assertEquals(2,(int) list.getTail().data);


    
        list.sortedInsert(new DNode<Integer>(1));
        assertEquals(2, list.getSize());
        assertEquals(1, (int) list.getHead().data);
        assertEquals(2,(int) list.getTail().data);


        list.sortedInsert(new DNode<Integer>(3));
        assertEquals(3, list.getSize());
        assertEquals(1, (int) list.getHead().data);
        assertEquals(3,(int) list.getTail().data);



    }
    @Test
    public void testDeleteHead(){

        SLL<Integer> list = new SLL<Integer>();
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
        SLL<Integer> list = new SLL<Integer>();
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
        SLL<Integer> list = new SLL<>();

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
        SLL<Integer> list = new SLL<>();

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

   
    @Test
    public void testPrint(){
        SLL<Integer> list = new SLL<>();

        list.insert(new DNode<Integer>(1), 0);
        list.insert(new DNode<Integer>(2), 1);
        list.insert(new DNode<Integer>(3), 2);
      
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

       list.print();


       String expectedOutput = "List length: 3\nSorted: Yes\nList content: 1 2 3 \n";
        assertEquals(expectedOutput, outputStream.toString());



    }
}

