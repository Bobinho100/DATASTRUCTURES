package main.java.mylib.datastructures.Trees;

import main.java.mylib.datastructures.nodes.TNode;

public class BST {

    protected TNode root;

    // Default constructor
    public BST() {
        this.root = null;
    }

    // Overload constructor with an integer value
    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null,0);
    }

    // Overload constructor with a TNode object
    public BST(TNode obj) {
        this.root = obj;
    }

    // Getter for root
    public TNode getRoot() {
        return root;
    }

    // Setter for root
    public void setRoot(TNode root) {
        this.root = root;
    }

    // Insert a new node with data val into the tree
    public void insert(int val) {
        TNode newNode = new TNode(val, 0, null, null, null,0);
        insert(newNode);
    }

    // Insert a TNode object into the tree
    public void insert(TNode node) {
        if (root == null) {
            root = node;
        } else {
            TNode current = root;
            while (true) {
                if (node.getData() < current.getData()) {
                    if (current.getLeft() == null) {
                        current.setLeft(node);
                        node.setParent(current);
                        break;
                    }
                    current = current.getLeft();
                } else {
                    if (current.getRight() == null) {
                        current.setRight(node);
                        node.setParent(current);
                        break;
                    }
                    current = current.getRight();
                }
            }
        }
    }

    // Delete a node with data val from the tree
    public void delete(int val) {
        TNode nodeToDelete = search(val);
        if (nodeToDelete != null) {
            delete(nodeToDelete);
        } else {
            System.out.println("Value not found in tree.");
        }
    }

    // Delete a given node from the tree
    protected void delete(TNode node) {
        // Case 1: Node has no children
        if (node.getLeft() == null && node.getRight() == null) {
            if (node.getParent() == null) {
                // The node is the root
                root = null;
            } else if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(null);
            } else {
                node.getParent().setRight(null);
            }
        }
        // Case 2: Node has one child
        else if (node.getLeft() == null) {
            if (node.getParent() == null) {
                // The node is the root
                root = node.getRight();
                node.getRight().setParent(null);
            } else if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(node.getRight());
                node.getRight().setParent(node.getParent());
            } else {
                node.getParent().setRight(node.getRight());
                node.getRight().setParent(node.getParent());
            }
        } else if (node.getRight() == null) {
            if (node.getParent() == null) {
                // The node is the root
                root = node.getLeft();
                node.getLeft().setParent(null);
            } else if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(node.getLeft());
                node.getLeft().setParent(node.getParent());
            } else {
                node.getParent().setRight(node.getLeft());
                node.getLeft().setParent(node.getParent());
            }
        }
        // Case 3: Node has two children
        else {
            TNode successor = findSuccessor(node);
            node.setData(successor.getData());
            delete(successor);
}
}

// Helper method to find the successor of a given node
private TNode findSuccessor(TNode node) {
    TNode successor = node.getRight();
    while (successor.getLeft() != null) {
        successor = successor.getLeft();
    }
    return successor;
}


// Search for a node with a given value in the tree
public TNode search(int val) {
    TNode current = root;
    while (current != null) {
        if (current.getData() == val) {
            return current;
        } else if (val < current.getData()) {
            current = current.getLeft();
        } else {
            current = current.getRight();
        }
    }
    return null;
}

public void printInOrder() {
    inOrderTraversal(root);
}

private void inOrderTraversal(TNode node) {
    if (node != null) {
        inOrderTraversal(node.getLeft());
        System.out.print(node.getData() + " ");
        inOrderTraversal(node.getRight());
    }
}

public void printBF() {
    if (root == null) {
        return;
    }

    int height = getHeight(root);
    for (int i = 1; i <= height; i++) {
        printLevel(root, i);
        System.out.println();
    }
}

private int getHeight(TNode node) {
    if (node == null) {
        return 0;
    } else {
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

private void printLevel(TNode node, int level) {
    if (node == null) {
        return;
    } else if (level == 1) {
        System.out.print(node.getData() + " ");
    } else {
        printLevel(node.getLeft(), level - 1);
        printLevel(node.getRight(), level - 1);
    }
}


}
