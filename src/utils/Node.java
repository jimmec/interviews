package utils;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 07/09/14
 * Time: 6:57 PM
 * Represents a data node in a tree, linked list, etc.
 */
public abstract class Node<T> {
    private T val;

    public Node(T val) {
        this.val = val;
    }

    public T getVal() {
        return this.val;
    }

    public void setVal(T value) {
        this.val = value;
    }
}
