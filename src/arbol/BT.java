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
public class BT <E> {
    private Node<E> root;
    public BT(){
        this.root=null;
    }
    
    public boolean  isEmpty(){
        return root==null;
    }
    
    public boolean addLeft(E child, E parent){
        Node<E> nch= new Node<> (child);
        if (child== null)return false;
        else if(isEmpty() && parent==null) {
            root=nch;
            return true;    
        }
        else{
            Node<E> nadd=searchNode(parent);
            nadd.setLeft(new Node<>(child));
            
            return true;
        }
    }
    public boolean addRight(E child, E parent){
        Node<E> nch= new Node<> (child);
        if (child== null)return false;
        else if(isEmpty() && parent==null) {
            root=nch;
            return true;    
        }
        else{
            Node<E> nadd=searchNode(parent);
            nadd.setRight(new Node<>(child));
            
            return true;
        }
    }
    
    private Node<E> searchNode(E data){
        return searchNode(data, root);
    }
    private Node<E> searchNode(E data,Node<E> n ){
        if (n==null||data==null) 
            return null;
        else if(n.getData().equals(data))
            return n;
        else{
            Node<E> node= searchNode(data,n.getLeft());
            if(node!=null) 
                return node;
            else 
                return searchNode(data,n.getRight());
        }
    }
    
}
