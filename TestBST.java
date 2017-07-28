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
public class TestBST {
    public static void main(String[]args){
        //create a BST
        BST<String> tree=new BST<String>();
        tree.insert("george");
        tree.insert("michael");
        tree.insert("adam");
        tree.insert("blessed");
        System.out.print("Inorder(sorted):");
        tree.inorder();
         System.out.print("\nPostorder:");
        tree.postorder();
         System.out.print("\nPreorder:");
        tree.preorder();
        System.out.print("\nthe number of nodes is "+tree.getSize());
        System.out.print("\nIs Peter in the tree?"+tree.search("Peter"));
        System.out.print("\nA path from the root to peter is:");
        java.util.ArrayList<BST.TreeNode<String>> path
                =tree.path("peter");
        for(int i=0;path!=null && i<path.size();i++)
        System.out.print(path.get(i).element+"");
        Integer[] numbers={2,4,3,1,8,5,6,7};
        BST<Integer> intTree=new BST<Integer>(numbers);
        System.out.print("\nInorder (sorted):");
                intTree.inorder();
    }
    
}
