package com.sv.restapi.lab1;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class BinaryTree{
    Node root;

    BinaryTree(){
        root=null;
    }
    /* Compute the "height" of a tree -- the number of
   nodes along the longest path from the root node
   down to the farthest leaf node.*/
    int height(Node root){
        if (root==null)
            return 0;
       int lheight=height(root.left);
       int rheight=height(root.right);
        if(lheight>rheight) return lheight+1;
        else return rheight+1;
    }
    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }


}


public class BtreeLvlOrdrTraverse {
    public static void main(String[] args){
        BinaryTree bt=new BinaryTree();
        bt.root=new Node(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(3);
        bt.root.left.left=new Node(4);
        bt.root.left.right=new Node(5);
        bt.root.right.left=new Node(6);
        bt.root.right.right=new Node(7);
        System.out.println("Height of Binary Tree:"+bt.height(bt.root));
        bt.printLevelOrder();
//
//        Queue q=new LinkedList();
//        q.add(bt.root.data);
//        System.out.println("Level Order Traversal:"+q.remove());
//        q.add(bt.root.left.data);
//        q.add(bt.root.right.data);
//        System.out.println("Level Order Traversal:"+q.remove());

    }
}
