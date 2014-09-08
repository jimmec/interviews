package solutions.Misc;

import utils.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 07/09/14
 * Time: 7:12 PM
 * Partial implementation of a binary tree in-order iterator
 * without using recursion.
 *
 * Simple solution simply emulates recursion with an explicit stack
 */
public class BinaryTreeIterator<T> {
    private BinaryTreeNode<T> root;
    private Deque<BinaryTreeNode<T>> stack;

    public BinaryTreeIterator(BinaryTreeNode<T> treeRoot) {
        stack = new ArrayDeque<BinaryTreeNode<T>>(5);
        this.root = treeRoot;
        BinaryTreeNode currNode = treeRoot;

        stack.addFirst(currNode);
        pushAllLeftChildren(currNode);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public BinaryTreeNode<T> next() {
        BinaryTreeNode<T> returnNode = stack.removeFirst();
        BinaryTreeNode<T> currNode = returnNode;
        if (currNode.getRightChild() != null) {
            currNode = currNode.getRightChild();
            stack.addFirst(currNode);
            pushAllLeftChildren(currNode);
        }

        return returnNode;
    }

    private void pushAllLeftChildren(BinaryTreeNode ancestor) {
        BinaryTreeNode currNode = ancestor;

        while (currNode.getLeftChild() != null) {
            currNode = currNode.getLeftChild();
            stack.addFirst(currNode);
        }
    }

    public static class IteratorTester {
        public static void main(String[] args) {
            // make a test tree
            BinaryTreeNode<Integer> root = (new BinaryTreeNode<Integer>(2)).withLeftChildVal(1).withRightChildVal(3);

            // test in order iterator, should see 1,2,3
            BinaryTreeIterator<Integer> it = new BinaryTreeIterator<Integer>(root);
            while(it.hasNext()) {
                System.out.println(it.next().getVal());
            }

            // make a bigger tree
            BinaryTreeNode<Integer> left = root;
            // incomplete sub tree
            BinaryTreeNode<Integer> right = (new BinaryTreeNode<Integer>(6)).withRightChildVal(7);
            root = new BinaryTreeNode<Integer>(4);
            root.setRightChild(right);
            root.setLeftChild(left);

            // test in order iterator, should see 1,2,3,4,6,7
            BinaryTreeIterator<Integer> it2 = new BinaryTreeIterator<Integer>(root);
            while(it2.hasNext()) {
                System.out.println(it2.next().getVal());
            }
        }
    }
}