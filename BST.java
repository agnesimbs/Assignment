/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author AGNES
 */
public class BST<E extends Comparable<E>>
       extends AbstractTree<E> {
    protected TreeNode<E>root;
    protected int size=0;
    /*create a default binary search tree*/
    public BST(){
        
    }
    /*Create a binary search tree from an array of objects*/
    public BST(E[] objects){
        for(int i=0;i<objects.length;i++)
            insert(objects[i]);
    }
    @Override /**return true if the element is in the tree*/
    public boolean search(E e){
        TreeNode<E> current=root;//start from the root
        while (current!=null){
            if (e.compareTo(current.element)<0){
                current=current.left;
            }
            else if(e.compareTo(current.element)>0){
            current=current.right;
        }
            else//element matches current.element
                return true;
        }
        return false;
    }
    @Override/** Insert element e into the binary search tree.
     Return true if the element is inserted successfully*/
    public boolean insert(E e){
        if (root==null)
            root=createNewNode(e);//create a new root
        else{
            //locate the parent node
            TreeNode<E>parent=null;
            TreeNode<E>current=root;
            while(current!=null)
                if(e.compareTo(current.element)<0){
                    parent=current;
                    current=current.left;
                }
                else if(e.compareTo(current.element)>0){
                    parent=current;
                    current=current.right;
                }
            else
                    return false;//duplicate node not inserted
            //create the new node and attach it to the parent node
            if(e.compareTo(parent.element)<0)
                parent.left=createNewNode(e);
            else
                parent.right=createNewNode(e);
        }
        size++;
        return true;//element inserted
    }
    protected TreeNode<E>createNewNode(E e){
        return new TreeNode<E>(e);
    }
    @Override /** Inorder traversal from the root*/
    public void inorder(){
        inorder(root);
    }/** inorder traversal from a subtree*/
    protected void inorder(TreeNode<E> root){
        if(root==null)return;
        inorder(root.left);
        System.out.print(root.element+"");
        order += root.element+",";
        inorder(root.right);
    }
    @Override //postorder traversal from the root
    public void postorder(){
        postorder(root);
    }
    protected void postorder(TreeNode<E> root){
        if(root==null)return;
        postorder(root.left);
        postorder(root.right);
        order +=  root.element + ", ";
        // System.out.println(root.element+"");
    }
    @Override//preorder traversal from a subtree
    public void preorder(){
        preorder(root);
    }
    //preorder traversal from a subtree
    String order = new String();
    protected void preorder(TreeNode<E> root){
        if(root==null)return;
        order +=  root.element + ", ";
        //System.out.print(root.element+"");
        
        preorder(root.left);
        preorder(root.right);
        
    }/** the inner class is static because it does not access 
     any instance members defined in its outer class*/
    public static class TreeNode<E extends Comparable<E>>{
    protected E element;
    protected TreeNode<E>left;
    protected TreeNode<E>right;
    public TreeNode(E e){
        element=e;
    }
}
@Override //get the number of nodes in the tree
public int getSize(){
return size;
}

//returns the root of the tree
public TreeNode<E>getRoot(){
return root;
}

//returns a path from the root leading to the specified element
public java.util.ArrayList<TreeNode<E>>path(E e){
java.util.ArrayList<TreeNode<E>>list=
new java.util.ArrayList<TreeNode<E>>();
TreeNode<E> current=root;//Start from the root
while(current!=null){
list.add(current); //add the node to the list
if (e.compareTo(current.element)<0){
current=current.right;
}
else
break;
}
return list; //return an array of nodes
}
@Override/** Delete an element from the binary search tree
 Return true if the element is deleted successfully.
 return false if the element is not in the true*/
public boolean delete(E e){
    //locate the node to be deleted and also locate its parent node
TreeNode<E>parent=null;
TreeNode<E> current=root;
while(current!=null){
if(e.compareTo(current.element)<0){
parent=current;
current=current.left;
}
else if( e.compareTo(current.element)<0){
parent=current;
current=current.right;
}
else
break;//element is in the tree pointed at by current
}
if(current==null)
return false;//element is not in the tree
//case1:current has no left children
if(current.left==null){
    //connect the parent with the right child of the current node
if (parent==null){
root=current.right;
}
else{
   
if(e.compareTo(parent.element)<0)
parent.left=current.right;
else
parent.right=current.right;
}
}
else{ //case2:the node has a left child
    //locate the rightmost node in the left subtree
    //of the current node and also its parent
TreeNode<E>parentOfRightMost=current;
TreeNode<E>rightMost=current.left;
while(rightMost.right!=null){
parentOfRightMost=rightMost;
rightMost=rightMost.right;
}
//replace the element in the current by the element in the rightmost
current.element=rightMost.element;
// Eliminate rightmost node 
if(parentOfRightMost.right==rightMost)
parentOfRightMost.right=rightMost.left;
else
    // Special case: parentOfRightMost == current 
parentOfRightMost.left=rightMost.left;
}
size--;
return true;//element deleted
}
@Override/** obtain an iterator.use inorder*/
public java.util.Iterator<E>iterator(){
return new InorderIterator();
}

//inner class inorderiterator
private class InorderIterator implements java.util.Iterator<E>{
    //store the elements in a list
    private java.util.ArrayList<E> list=
            new java.util.ArrayList<E>();
    private int current=0;//point to the current element in the list
    public InorderIterator(){
        inorder(); //traverse binary tree and store elements in the list
    }
    private void inorder(){
        inorder(root);
    }
    //inorder traversal from a subtree
    private void inorder(TreeNode<E> root){
        if (root==null)return;
        inorder(root.left);
        list.add(root.element);
        inorder(root.right);
    }
    @Override //more elements for traversing
    public boolean hasNext(){
        if (current<list.size())
            return true;
        return false;
    }
    @Override //get the current element and move to the next
    public E next(){
        return list.get(current++);
    }
    @Override //remove the current element
    public void remove(){
        delete(list.get(current));//delete the current element
        list.clear();//clear list
        inorder();//rebuild the list
    }
}

//remove all elements from the tree
public void clear(){
root=null;
size=0;
}
    
}
