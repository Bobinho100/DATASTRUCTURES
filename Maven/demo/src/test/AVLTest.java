package test;
import mylib.datastructures.Trees.AVL;
import mylib.datastructures.nodes.TNode;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AVLTest {

    @Test
    public void testInsert() {
        AVL avl = new AVL();

        // Test inserting a single value
        avl.insert(10);
        assertEquals(10, avl.getRoot().getData());
        assertNull(avl.getRoot().getLeft());
        assertNull(avl.getRoot().getRight());

        // Test inserting multiple values
        avl.insert(5);
        avl.insert(15);
        avl.insert(3);
        avl.insert(7);
        avl.insert(12);
        avl.insert(20);
        assertEquals(10, avl.getRoot().getData());
        assertEquals(5, avl.getRoot().getLeft().getData());
        assertEquals(3, avl.getRoot().getLeft().getLeft().getData());
        assertEquals(7, avl.getRoot().getLeft().getRight().getData());
        assertEquals(15, avl.getRoot().getRight().getData());
        assertEquals(12, avl.getRoot().getRight().getLeft().getData());
        assertEquals(20, avl.getRoot().getRight().getRight().getData());

        // Test inserting a value that already exists in the tree
        avl.insert(12);
        assertEquals(10, avl.getRoot().getData());
        assertEquals(5, avl.getRoot().getLeft().getData());
        assertEquals(3, avl.getRoot().getLeft().getLeft().getData());
        assertEquals(7, avl.getRoot().getLeft().getRight().getData());
        assertEquals(15, avl.getRoot().getRight().getData());
        assertEquals(12, avl.getRoot().getRight().getLeft().getData());
        assertEquals(20, avl.getRoot().getRight().getRight().getData());
    }


    @Test
    public void testInsertNode() {
        AVL avl = new AVL();
        TNode node = null;
        
        // Test inserting into an empty tree
        node = avl.insert(node, 5);
        assertNotNull(node);
        assertEquals(5, node.getData());
        
        // Test inserting a value less than the root node
        node = avl.insert(node, 3);
        assertEquals(5, node.getData());
        assertEquals(3, node.getLeft().getData());
        
        // Test inserting a value greater than the root node
        node = avl.insert(node, 7);
        assertEquals(5, node.getData());
        assertEquals(3, node.getLeft().getData());
        assertEquals(7, node.getRight().getData());
        
        // Test inserting a value equal to an existing node's value
        node = avl.insert(node, 3);
        assertEquals(5, node.getData());
        assertEquals(3, node.getLeft().getData());
        assertEquals(7, node.getRight().getData());
    }

    @Test
    public void testDelete() {
        AVL tree = new AVL();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);
        tree.insert(17);

        // Test deleting a leaf node
        assertNotNull(tree.search(3));
        tree.delete(3);
        assertNull(tree.search(3));
        
        // Test deleting a node with one child
        assertNotNull(tree.search(12));
        tree.delete(12);
        assertNull(tree.search(12));
        
        // Test deleting a node with two children
        assertNotNull(tree.search(10));
        tree.delete(10);
        assertNull(tree.search(10));
        
        // Test deleting the root node
        assertNotNull(tree.search(15));
        tree.delete(15);
        assertNull(tree.search(15));
    }


    @Test
    public void testPrintInOrder() {
        // Arrange
       AVL tree = new AVL();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        tree.printInOrder();

        // Assert
        assertEquals("3 5 7 ", outContent.toString());
    }

    @Test
    public void testPrintBF() {
        // Arrange
        AVL tree = new AVL();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        tree.printBF();

        // Assert
        assertEquals("3(0) 5(0) 7(0) ", outContent.toString());
    }



    private AVL avl;

    @Before
    public void setUp() {
        avl = new AVL();
    }

    public void testAVLTreeIsEmpty() {
        AVL avl = new AVL();
        assertTrue(avl.getRoot() == null);
    }

    @Test
    public void testAVLTreeInsertAndDelete() {
        AVL avl = new AVL();
        avl.insert(4);
        assertEquals(4, avl.getRoot().getData());
        
        avl.insert(2);
        assertEquals(2, avl.getRoot().getLeft().getData());
        
        avl.insert(6);
        assertEquals(6, avl.getRoot().getRight().getData());
        
        avl.insert(1);
        assertEquals(1, avl.getRoot().getLeft().getLeft().getData());
        
        avl.insert(3);
        assertEquals(3, avl.getRoot().getLeft().getRight().getData());
        
        avl.insert(5);
        assertEquals(5, avl.getRoot().getRight().getLeft().getData());
        
        avl.insert(7);
        assertEquals(7, avl.getRoot().getRight().getRight().getData());
        
        avl.delete(4);
        assertEquals(5, avl.getRoot().getData());
        
        avl.delete(5);
        assertEquals(6, avl.getRoot().getData());
        
        avl.delete(6);
        assertEquals(2, avl.getRoot().getData());
        
        avl.delete(2);
        assertEquals(3, avl.getRoot().getData());
        
        avl.delete(1);
        assertEquals(3, avl.getRoot().getData());
        
        avl.delete(7);
        assertEquals(3, avl.getRoot().getData());
        
        avl.delete(3);
        assertTrue(avl.getRoot() == null);
    }
    
    @Test
    public void testAVLTreeIsEmptyAfterClear() {
        AVL avl = new AVL();
        avl.insert(4);
        avl.delete(4);
        assertTrue(avl.getRoot() == null);
    }

    @Test
    public void testSingleInsert() {
        avl.insert(8);
        assertEquals(8, avl.getRoot().getData());
    }

    @Test
    public void testInsertAndRotateLeft() {
        avl.insert(4);
        avl.insert(5);
        avl.insert(6);
        assertEquals(5, avl.getRoot().getData());
        assertEquals(4, avl.getRoot().getLeft().getData());
        assertEquals(6, avl.getRoot().getRight().getData());
    }

    @Test
    public void testInsertAndRotateRight() {
        avl.insert(6);
        avl.insert(5);
        avl.insert(4);
        assertEquals(5, avl.getRoot().getData());
        assertEquals(4, avl.getRoot().getLeft().getData());
        assertEquals(6, avl.getRoot().getRight().getData());
    }

    @Test
    public void testInsertAndRotateLeftRight() {
        avl.insert(4);
        avl.insert(6);
        avl.insert(5);
        assertEquals(5, avl.getRoot().getData());
        assertEquals(4, avl.getRoot().getLeft().getData());
        assertEquals(6, avl.getRoot().getRight().getData());
    }

    @Test
    public void testInsertAndRotateRightLeft() {
        avl.insert(6);
        avl.insert(4);
        avl.insert(5);
        assertEquals(5, avl.getRoot().getData());
        assertEquals(4, avl.getRoot().getLeft().getData());
        assertEquals(6, avl.getRoot().getRight().getData());
    }
}

