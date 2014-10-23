package utils;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 07/09/14
 * Time: 7:01 PM
 * Represents a node in a binary tree
 */
public class BinaryTreeNode<T> extends Node<T> {
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T val) {
        super(val);
    }
    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<T> withRightChildVal(T rightVal) {
        BinaryTreeNode right = new BinaryTreeNode(rightVal);
        this.setRightChild(right);
        return this;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> withLeftChildVal(T leftVal) {
        BinaryTreeNode left = new BinaryTreeNode(leftVal);
        this.setLeftChild(left);
        return this;
    }
}
