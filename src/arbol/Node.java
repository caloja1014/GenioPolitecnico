/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author CltControl
 */
public class Node<E> {
    private E data;
    private Node<E> left;
    private Node<E> right;

    public Node(E data){
        this.data=data;
        left=right=null;
    }

    /**
     * @return the data
     */
    public E getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * @return the left
     */
    public Node<E> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node<E> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Node<E> getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Node<E> right) {
        this.right = right;
    }
}
