
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CltControl
 */
public class BT <E> {
    private Node<E> root;
    boolean isLeft;
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
    public boolean remove(E data){
        Node<E> n= searchNode(data, root);
        boolean b=n.isIsLeft();
        //System.out.println("booleano del remove" + b+ "el dato a remover es: "+ n.getData());
        n=null;
        return b;
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
    public static BT<String> cargarArbol(){
        BT<String> arbol=new BT<>();
        Stack<Node<String>> pila=new Stack<>();
        try(BufferedReader br=new BufferedReader(new FileReader("src/data/arbol.txt"))){
            String line=null;
            while((line=br.readLine())!=null){
                String identificador=line.split(" ")[0];
                String texto=line.substring(3);
                if(identificador.equals("#R")){
                    Node<String> node=new Node<>(texto);
                    pila.push(node);
                }else{
                    Node<String> node=new Node<>(texto);
                    node.setRight(pila.pop());
                    node.setLeft(pila.pop());
                    pila.push(node);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(BT.class.getName()).log(Level.SEVERE, null, ex);
        }
        arbol.setRoot(pila.pop());
        return arbol;
    }
    public void guardarArbol() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/arbol.txt"))) {
            guardarArbol(root);
        } catch (IOException ex) {
            Logger.getLogger(BT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void guardarArbol(Node<E> n) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/arbol.txt", true))) {
            if (n != null) {
                guardarArbol(n.getLeft());
                guardarArbol(n.getRight());
      
                if(n.isHoja())
                    bw.write("#R "+ (String) n.getData());
                else{
                    bw.write("#P "+ (String) n.getData());
                }
                if(n!=root)
                    bw.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(BT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

