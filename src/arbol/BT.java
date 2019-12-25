
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
    public boolean add(E child, E parent){
        Node<E>nch=new Node<>(child);
        if(child==null){
            return false;
        }
        else if(isEmpty() && parent==null){
            root=nch;
            return true;
        }else if(parent!=null){
            if(searchNode(child)==null){
                Node<E> np=searchNode(parent);
                if(np==null || np.getLeft()!=null || np.getRight()!=null)
                    return false;
                else if(np.getLeft()==null)
                    np.setLeft(nch);
                else
                    np.setRight(nch);
                
            }
            return true;
        }else{
            return false;
        }
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
            if(nadd!=null){
                nadd.setLeft(new Node<>(child));
                return true;
            }
            return false;
 
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
            if(nadd!=null){
                nadd.setRight(new Node<>(child));
                return true;
            }
            return false;
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

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }
    
    public void posOrden(){
        posOrden(root);
        
    }
    public void posOrden(Node<E>n){
        if(n!=null){
            posOrden(n.getLeft());
            posOrden(n.getRight());
            System.out.println(n.getData());
        }
    }
}

