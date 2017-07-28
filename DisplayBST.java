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
import java.awt.Dimension;
import javax.swing.*;

public class DisplayBST extends JFrame{
    public DisplayBST(){
        //create a view
        add(new TreeControl (new BST<Integer>()));
        setVisible(true);
        setSize(new Dimension(400,500));
        //setDefaultCloseOperation(JFrame.);
        setTitle("BINARY SEARCH TREE");
    }
    public static void main(String args[]){
        new DisplayBST();
    }
    
    
}




