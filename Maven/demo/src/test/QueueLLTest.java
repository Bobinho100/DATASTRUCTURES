package test;
import mylib.datastructures.Linear.QueueLL;
import mylib.datastructures.nodes.DNode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueLLTest {


    @Test
    public void testEnqueue(){
        QueueLL<Integer> queue = new QueueLL<>();
        queue.enqueue(new DNode<>(10));
        queue.enqueue(new DNode<>(9));
        queue.enqueue(new DNode<>(8));
        queue.enqueue(new DNode<>(7));
        queue.enqueue(new DNode<>(6));

        assertEquals(5, queue.size());
        assertEquals(10,(int) queue.peek().data);
    }
    @Test
    public void testDequeue(){

        QueueLL<Integer> queue = new QueueLL<>();
        queue.enqueue(new DNode<>(10));
        queue.enqueue(new DNode<>(9));
        queue.enqueue(new DNode<>(8));
        queue.enqueue(new DNode<>(7));
        queue.enqueue(new DNode<>(6));

        queue.dequeue();
        queue.dequeue();

        assertEquals(3, queue.size());
        assertEquals(8,(int) queue.peek().data);


    }
    
}
