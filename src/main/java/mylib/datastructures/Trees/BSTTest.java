package main.java.mylib.datastructures.Trees;
import main.java.mylib.datastructures.nodes.TNode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BSTTest {


    @Test
    public void testBST(){
        BST bst = new BST();
        assertEquals(0, bst.getRoot().getData());
    }

    @Test
    public void insert(){
        BST bst = new BST();

        bst.insert(2);
        bst.insert(10);
        bst.insert(7);
        assertEquals(10, bst.getRoot());
    }
    
}
