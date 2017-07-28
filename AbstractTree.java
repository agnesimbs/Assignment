/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author AGNES
 */
//abstract class
public abstract class AbstractTree<E extends Comparable<E>>
implements Tree<E>{
    @Override  /*Inorder traversal from the root*/
    public void inorder(){ //default inorder implementation
        
    }
    @Override /*Postorder traversal from the root*/
    public void postorder(){ //postorder implementation
        
    }
    @Override /*Preorder traversal from the root*/
    public void preorder(){ //preorder implementation
        
    }
    @Override /*Return true if the tree is empty*/
    public boolean isEmpty(){ //isempty implementation
        return getSize()==0;
    }
    @Override /*Return an iterator for the tree*/
    public java.util.Iterator<E>iterator(){ //default iterator implementation
        return null;
    }
}
