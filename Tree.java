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
public interface Tree <E extends Comparable<E>> extends Iterable<E> {
    /**Return true if the element is in the tree*/
    public boolean search(E e);
    /**Insert an element e into the binary search tree.
     * Return true if the element is inserted successfully*/
     public boolean insert(E e);
     /** Delete the specified element from the tree.
      Return true if the element is deleted successfully*/
      public boolean delete(E e);
      /** inorder traversal from the root*/
      public void inorder();
      /** postorder traversal from the root*/
      public void postorder();
      /** preorder traversal from the root*/
      public void preorder();
      /** Get the number of nodes in the tree*/
      public int getSize();
      /** Return true if the tree is empty*/
      public boolean isEmpty();
      /** Return an iterator to traverse elements in */
      public java.util.Iterator<E> iterator();
    
}
