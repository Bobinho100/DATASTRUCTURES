package main.java.mylib.datastructures.nodes;

public class TNode {

    public int data;
    public TNode left;
    public TNode right;
    public TNode parent;
    public int balance;
    public int height; // new field for storing the height of the node

    public TNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
    

    // Default constructor
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
        this.height = 1;
    }

    // Overload constructor
    public TNode(int data, int balance, TNode parent, TNode left, TNode right, int height) {
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.height = height;
    }

    // Getters and Setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // toString method
    public String toString() {
        return Integer.toString(data);
    }

    // print method
    public void print() {
        System.out.println("Data: " + data + ", Balance: " + balance + ", Height: " + height);
    }
    
}
