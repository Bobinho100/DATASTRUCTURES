package main.java.mylib.datastructures.Trees;
import main.java.mylib.datastructures.nodes.TNode;
import java.util.Stack;


public class AVL extends BST {
    
    // Constructor: initialize root to null
    public AVL() {
        root = null;
    }
    
    // Overload constructor: create AVL tree with root node containing val
    public AVL(int val) {
        root = new TNode(val);
    }
    
    // Overload constructor: create AVL tree with root node as obj
    public AVL(TNode obj) {
        root = obj;
        if (obj.getLeft() != null || obj.getRight() != null) {
            balanceTree();
        }
    }
    
    // Insert a value into the AVL tree and balance it
    public void insert(int val) {
        root = insertHelper(root, val);
        balanceTree();
    }
    
    // Helper method for insert()
    private TNode insertHelper(TNode node, int val) {
        if (node == null) {
            return new TNode(val);
        } else if (val < node.getData()) {
            node.setLeft(insertHelper(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(insertHelper(node.getRight(), val));
        } else {
            // Value already exists in the tree
            return node;
        }
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1 && val < node.getLeft().getData()) {
            return rotateRight(node);
        }
        if (balanceFactor < -1 && val > node.getRight().getData()) {
            return rotateLeft(node);
        }
        if (balanceFactor > 1 && val > node.getLeft().getData()) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if (balanceFactor < -1 && val < node.getRight().getData()) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }
        return node;
    }
    
    // Get the balance factor of a node
    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        } else {
            return getHeight(node.getLeft()) - getHeight(node.getRight());
        }
    }
    
    // Perform a left rotation on a node
    private TNode rotateLeft(TNode node) {
        TNode rightChild = node.getRight();
        TNode leftGrandchild = rightChild.getLeft();
        rightChild.setLeft(node);
        node.setRight(leftGrandchild);
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        rightChild.setHeight(Math.max(getHeight(rightChild.getLeft()), getHeight(rightChild.getRight())) + 1);
        return rightChild;
    }
    
    // Perform a right rotation on a node
    private TNode rotateRight(TNode node) {
        TNode leftChild = node.getLeft();
        TNode rightGrandchild = leftChild.getRight();
        leftChild.setRight(node);
        node.setLeft(rightGrandchild);
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        leftChild.setHeight(Math.max(getHeight(leftChild.getLeft()), getHeight(leftChild.getRight())) + 1);
        return leftChild;
    }
    
  // Balance the AVL tree using an iterative algorithm
private void balanceTree() {
    Stack<TNode> stack = new Stack<>();
    TNode current = root;
    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.getLeft();
        }
        current = stack.pop();
        int balanceFactor = getBalanceFactor(current);

        if (balanceFactor > 1) {
            if (getBalanceFactor(current.getLeft()) >= 0) {
                // Left-Left case
                current = rotateRight(current);
            } else {
                // Left-Right case
                current.setLeft(rotateLeft(current.getLeft()));
                current = rotateRight(current);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(current.getRight()) <= 0) {
                // Right-Right case
                current = rotateLeft(current);
            } else {
                // Right-Left case
                current.setRight(rotateRight(current.getRight()));
                current = rotateLeft(current);
            }
        }

        current = current.getRight();
    }
}


// Get the height of a node
private int getHeight(TNode node) {
    if (node == null) {
        return 0;
    }
    return node.getHeight();
}


public TNode getRoot() {
    return root;
}

public void setRoot(TNode newRoot) {
    if (newRoot == null) {
        root = null;
        return;
    }
    
    if (newRoot.getLeft() == null && newRoot.getRight() == null) {
        // No child nodes, simply set new root
        root = newRoot;
    } else if (newRoot.getLeft() == null) {
        // Only right child, create new balanced tree with right child as root
        AVL rightTree = new AVL(newRoot.getRight());
        root = rightTree.getRoot();
        rightTree.setRoot(null);
    } else if (newRoot.getRight() == null) {
        // Only left child, create new balanced tree with left child as root
        AVL leftTree = new AVL(newRoot.getLeft());
        root = leftTree.getRoot();
        leftTree.setRoot(null);
    } else {
        // Both left and right children present, create new balanced tree
        AVL newTree = new AVL(newRoot);
        root = newTree.getRoot();
        newTree.setRoot(null);
    }
}



public TNode insert(TNode node, int val) {
    if (node == null) {
        return new TNode(val);
    }
    if (val < node.getData()) {
        node.setLeft(insert(node.getLeft(), val));
    } else {
        node.setRight(insert(node.getRight(), val));
    }
    // update the height and balance factor of the current node
    node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));
    int balanceFactor = getBalanceFactor(node);
    // check if the node is unbalanced and rotate if necessary
    if (balanceFactor > 1 && val < node.getLeft().getData()) {
        return rotateRight(node);
    }
    if (balanceFactor < -1 && val > node.getRight().getData()) {
        return rotateLeft(node);
    }
    if (balanceFactor > 1 && val > node.getLeft().getData()) {
        node.setLeft(rotateLeft(node.getLeft()));
        return rotateRight(node);
    }
    if (balanceFactor < -1 && val < node.getRight().getData()) {
        node.setRight(rotateRight(node.getRight()));
        return rotateLeft(node);
    }
    return node;
}

public void insert(TNode node) {
    super.insert(node); // call insert method of the parent class

    // balance the tree after insertion
    balanceTree();
}

public void delete(int val) {
    root = delete(root, val);
}

private TNode delete(TNode node, int val) {
    if (node == null) {
        System.out.println("Value not found in the tree");
        return null;
    }
    if (val < node.getData()) {
        node.setLeft(delete(node.getLeft(), val));
    } else if (val > node.getData()) {
        node.setRight(delete(node.getRight(), val));
    } else {
        if (node.getLeft() == null) {
            return node.getRight();
        } else if (node.getRight() == null) {
            return node.getLeft();
        } else {
            TNode successor = findSuccessor(node);
            node.setData(successor.getData());
            node.setRight(delete(node.getRight(), successor.getData()));
        }
    }
    node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));
    int balanceFactor = getBalanceFactor(node);
    if (balanceFactor > 1 && getBalanceFactor(node.getLeft()) >= 0) {
        return rotateRight(node);
    }
    if (balanceFactor > 1 && getBalanceFactor(node.getLeft()) < 0) {
        node.setLeft(rotateLeft(node.getLeft()));
        return rotateRight(node);
    }
    if (balanceFactor < -1 && getBalanceFactor(node.getRight()) <= 0) {
        return rotateLeft(node);
    }
    if (balanceFactor < -1 && getBalanceFactor(node.getRight()) > 0) {
        node.setRight(rotateRight(node.getRight()));
        return rotateLeft(node);
    }
    return node;
}

// Helper method to find the successor of a given node
private TNode findSuccessor(TNode node) {
    TNode successor = node.getRight();
    while (successor.getLeft() != null) {
        successor = successor.getLeft();
    }
    return successor;
}

public TNode Search(int val) {
    TNode curr = root;
    while (curr != null) {
        if (curr.getData() == val) {
            return curr;
        } else if (val < curr.getData()) {
            curr = curr.left;
        } else {
            curr = curr.right;
        }
    }
    return null;
}

public void printInOrder() {
    inOrderTraversal(root);
}

private void inOrderTraversal(TNode node) {
    if (node != null) {
        inOrderTraversal(node.left);
        System.out.print(node.getData() + " ");
        inOrderTraversal(node.right);
    }
}

public void printBF() {
    printBF(root);
}

private void printBF(TNode node) {
    if (node != null) {
        printBF(node.left);
        System.out.print(node.getData() + "(" + getBalanceFactor(node) + ") ");
        printBF(node.right);
    }
}


}
