package norman.unknown;

import norman.template.Template;

/**
 * Created by normansyahputa on 7/17/17.
 *
 * source : http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 */
public class DiameterOfTree2 extends Template{

    public DiameterOfTree2() {
        super("DiameterOfTree", "DiameterOfTree", LINUX, true);
    }

    class BinaryTree{
        Node root;

        /* Method to calculate the diameter and return it to main */
        int diameter(Node root)
        {
        /* base case if tree is empty */
            if (root == null)
                return 0;

        /* get the height of left and right sub trees */
            int lheight = height(root.left);
            int rheight = height(root.right);

        /* get the diameter of left and right subtrees */
            int ldiameter = diameter(root.left);
            int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
            return Math.max(lheight + rheight + 1,
                    Math.max(ldiameter, rdiameter));

        }

        /* A wrapper over diameter(Node root) */
        int diameter()
        {
            return diameter(root);
        }

        /*The function Compute the "height" of a tree. Height is the
          number f nodes along the longest path from the root node
          down to the farthest leaf node.*/
        int height(Node node)
        {
        /* base case tree is empty */
            if (node == null)
                return 0;

        /* If tree is not empty then height = 1 + max of left
           height and right heights */
            return (1 + Math.max(height(node.left), height(node.right)));
        }
    }



    @Override
    public void doSomething() {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.left = new Node(5);

        println("The diameter of given binary tree is : "
                + tree.diameter());
    }
}

/* Class containing left and right child of current
 node and key value*/
class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
