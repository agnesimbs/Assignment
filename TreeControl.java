package assignment;

/**
 *
 * @author AGNES
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TreeControl extends JPanel {

    private BST<Integer> tree; //A binary tree to be displayed
    private JTextField jtfkey = new JTextField(5);
    private TreeView view = new TreeView();
    private JButton jbtInsert = new JButton("Insert");
    private JButton jbtDelete = new JButton("Delete");
    private JButton jbtPreorder = new JButton("Preorder");
    private JButton jbtPostorder = new JButton("Postorder");
    private JButton jbtinorder = new JButton("Inorder");
   
    /**
     * Construct a view for a binary tree
     */
    public TreeControl(BST<Integer> tree) {
        this.tree = tree;//Set a binary tree to be displayed
        setUI();
    }

    /**
     * Initialize UI for binary tree
     */
    private void setUI() {
        this.setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter a key:"));
        panel.add(jtfkey);
        panel.add(jbtInsert);
        panel.add(jbtDelete);
        panel.add(jbtPreorder);
        panel.add(jbtPostorder);
        panel.add(jbtinorder);
        panel.setBackground(Color.blue);
        
        
        add(panel, BorderLayout.SOUTH);

        jbtInsert.addActionListener(new ActionListener() {
            @Override//process the insert button event
            public void actionPerformed(ActionEvent e) {
                int key = Integer.parseInt(jtfkey.getText());
                if (tree.search(key)) {//key is in the tree already
                    JOptionPane.showMessageDialog(null, key + "is already in the tree");
                } else {
                    tree.insert(key);//insert a new key
                    view.repaint();//Redisplay the tree

                }
            }
        });

        jbtDelete.addActionListener(new ActionListener() {
            @Override//process the delete button event
            public void actionPerformed(ActionEvent e) {
                int key = Integer.parseInt(jtfkey.getText());
                if (!tree.search(key)) {//key is not in the tree
                    JOptionPane.showMessageDialog(null, key + "is not in the tree");

                } else {
                    tree.delete(key);//delete a key
                    view.repaint();//redisplay the tree
                }
            }
        });
        
       jbtPreorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tree.preorder();
                JOptionPane.showMessageDialog(null, tree.order, "Pre-order", JOptionPane.INFORMATION_MESSAGE);
            }
        });
       
       jbtPostorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tree.postorder();
                JOptionPane.showMessageDialog(null, tree.order, "Post-order", JOptionPane.INFORMATION_MESSAGE);
            }
        });
       
       jbtinorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tree.inorder();
                //tree.order = tree.order.replace(tree.order., 0)
                JOptionPane.showMessageDialog(null, tree.order, "In-order", JOptionPane.INFORMATION_MESSAGE);
            }
        });
       
    }

    //Inner class TreeView for displaying a tree on a panel
    class TreeView extends JPanel {

        private int radius = 20;//tree node radius
        private int vGap = 50;//gap between two levels in a tree

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (tree.getRoot() != null) {
                //display tree recursively
                displayTree(g, tree.getRoot(), getWidth() / 2, 30, getWidth() / 4);
            }
        }

        /**
         * Display a subtree rooted at position(x,y)
         */
        private void displayTree(Graphics g,
                BST.TreeNode<Integer> root, int x, int y, int hGap) {
            //display the root
            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.drawString(root.element + "", x - 6, y + 4);
            if (root.left != null) {
                //draw a line to the left node
                connectTwoCircles(g, x - hGap, y + vGap, x, y);
                //draw the left subtree recursively
                displayTree(g, root.left, x - hGap, y + vGap, hGap / 2);
            }
            if (root.right != null) {
                //draw a line to the right node
                connectTwoCircles(g, x + hGap, y + vGap, x, y);
                //draw the right subtree recursively
                displayTree(g, root.right, x + hGap, y + vGap, hGap / 2);
            }
        }

        /**
         * connect two circles centered at(x1,y1) and(x2,y2)
         */
        private void connectTwoCircles(Graphics g,
                int x1, int y1, int x2, int y2) {
            double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
            int x11 = (int) (x1 - radius * (x1 - x2) / d);
            int y11 = (int) (y1 - radius * (y1 - y2) / d);
            int x21 = (int) (x2 + radius * (x1 - x2) / d);
            int y21 = (int) (y2 + radius * (y1 - y2) / d);
            g.drawLine(x11, y11, x21, y21);
        }
    }
}
