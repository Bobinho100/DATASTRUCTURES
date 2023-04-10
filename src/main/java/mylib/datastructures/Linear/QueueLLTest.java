package main.java.mylib.datastructures.Linear;
import main.java.mylib.datastructures.nodes.Node;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueLLTest {


    @Test
    public void testEnqueue(){
        QueueLL<Integer> queue = new QueueLL<>();
        queue.enqueue(new Node<>(10));
        queue.enqueue(new Node<>(9));
        queue.enqueue(new Node<>(8));
        queue.enqueue(new Node<>(7));
        queue.enqueue(new Node<>(6));

        assertEquals(5, queue.size());
        assertEquals(10,(int) queue.peek().data);
    }
    @Test
    public void testDequeue(){

        QueueLL<Integer> queue = new QueueLL<>();
        queue.enqueue(new Node<>(10));
        queue.enqueue(new Node<>(9));
        queue.enqueue(new Node<>(8));
        queue.enqueue(new Node<>(7));
        queue.enqueue(new Node<>(6));

        queue.dequeue();
        queue.dequeue();

        assertEquals(3, queue.size());
        assertEquals(8,(int) queue.peek().data);


    }
    
}
