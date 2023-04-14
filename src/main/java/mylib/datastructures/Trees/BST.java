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


    // Delete a node with a given value from the tree
    public void delete(int val) {
        TNode nodeToDelete = search(val);
        if (nodeToDelete == null) {
            System.out.println("Value " + val + " not found in the tree");
            return;
        }

        // Case 1: The node to be deleted is a leaf node
        if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {
            if (nodeToDelete == root) {
                root = null;
            } else if (nodeToDelete.getParent().getLeft() == nodeToDelete) {
                nodeToDelete.getParent().setLeft(null);
            } else {
                nodeToDelete.getParent().setRight(null);
            }
        }
        // Case 2: The node to be deleted has one child
        else if (nodeToDelete.getLeft() == null || nodeToDelete.getRight() == null) {
            TNode child;
            if (nodeToDelete.getLeft() != null) {
                child = nodeToDelete.getLeft();
            } else {
                child = nodeToDelete.getRight();
            }
            if (nodeToDelete == root) {
                root = child;
                child.setParent(null);
            } else if (nodeToDelete.getParent().getLeft() == nodeToDelete) {
                nodeToDelete.getParent().setLeft(child);
                child.setParent(nodeToDelete.getParent());
            } else {
                nodeToDelete.getParent().setRight(child);
                child.setParent(nodeToDelete.getParent());
            }
        }

          // Case 3: The node to be deleted has two children
          else

          {
          // Find the minimum node in the right subtree of the node to be deleted
          TNode minRight = nodeToDelete.getRight();
          while (minRight.getLeft() != null) {
          minRight = minRight.getLeft();
          }
                  // Copy the value of the minimum node into the node to be deleted
        nodeToDelete.setData(minRight.getData());

        // Remove the minimum node
        if (minRight.getRight() == null) {
            if (minRight.getParent().getLeft() == minRight) {
                minRight.getParent().setLeft(null);
            } else {
                minRight.getParent().setRight(null);
            }
        } else {
            if (minRight.getParent().getLeft() == minRight) {
                minRight.getParent().setLeft(minRight.getRight());
            } else {
                minRight.getParent().setRight(minRight.getRight());
            }
            minRight.getRight().setParent(minRight.getParent());
        }
    }
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
