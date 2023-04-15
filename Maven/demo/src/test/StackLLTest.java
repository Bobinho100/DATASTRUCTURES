package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mylib.datastructures.Linear.StackLL;
import mylib.datastructures.nodes.DNode;

public class StackLLTest {
    

    @Test
    public void testPush(){
        StackLL<Integer> stack = new StackLL<>();
        stack.push(new DNode<>(10));
        stack.push(new DNode<>(9));
        stack.push(new DNode<>(8));
        stack.push(new DNode<>(7));
        stack.push(new DNode<>(6));

        //assertEquals(10, stack.peek());
        assertEquals(5, stack.size());
        assertEquals(6,(int) stack.peek().data);
    }
    @Test
    public void testPop(){
        StackLL<Integer> stack = new StackLL<>();
        stack.push(new DNode<>(10));
        stack.push(new DNode<>(9));
        stack.push(new DNode<>(8));
        stack.push(new DNode<>(7));
        stack.push(new DNode<>(6));

        stack.pop();
        stack.pop();

        assertEquals(3, stack.size());
        assertEquals(8,(int) stack.peek().data);
    }

    
}
