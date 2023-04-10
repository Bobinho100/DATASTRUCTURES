package main.java.mylib.datastructures.Linear;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.mylib.datastructures.nodes.Node;

public class StackLLTest {
    

    @Test
    public void testPush(){
        StackLL<Integer> stack = new StackLL<>();
        stack.push(new Node<>(10));
        stack.push(new Node<>(9));
        stack.push(new Node<>(8));
        stack.push(new Node<>(7));
        stack.push(new Node<>(6));

        //assertEquals(10, stack.peek());
        assertEquals(5, stack.size());
        assertEquals(6,(int) stack.peek().data);
    }
    @Test
    public void testPop(){
        StackLL<Integer> stack = new StackLL<>();
        stack.push(new Node<>(10));
        stack.push(new Node<>(9));
        stack.push(new Node<>(8));
        stack.push(new Node<>(7));
        stack.push(new Node<>(6));

        stack.pop();
        stack.pop();

        assertEquals(3, stack.size());
        assertEquals(8,(int) stack.peek().data);
    }

    
}
