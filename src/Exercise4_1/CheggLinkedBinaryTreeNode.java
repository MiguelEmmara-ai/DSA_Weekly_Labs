package Exercise4_1;

import java.util.LinkedList;
import java.util.Queue;

class CheggLinkedBinaryTreeNode {
    int data;
    CheggLinkedBinaryTreeNode next;

    CheggLinkedBinaryTreeNode(int d) {
        data = d;
        next = null;
    }
}

class MutableTreeNode {
    int data;
    MutableTreeNode left, right = null;

    MutableTreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    CheggLinkedBinaryTreeNode head;
    MutableTreeNode root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.push(36);
        tree.push(30);
        tree.push(25);
        tree.push(15);
        tree.push(12);
        tree.push(10);
        MutableTreeNode node = tree.convertList2Binary(tree.root);

        System.out.println("Inorder Traversal of the" +
                " constructed Binary Tree is:");
        tree.inorderTraversal(node);
    }

    void push(int new_data) {
        CheggLinkedBinaryTreeNode new_node = new CheggLinkedBinaryTreeNode(new_data);
        new_node.next = head;
        head = new_node;
    }

    MutableTreeNode convertList2Binary(MutableTreeNode node) {
        Queue<MutableTreeNode> q =
                new LinkedList<MutableTreeNode>();
        if (head == null) {
            node = null;
            return null;
        }

        node = new MutableTreeNode(head.data);
        q.add(node);
        head = head.next;
        while (head != null) {

            MutableTreeNode parent = q.peek();
            MutableTreeNode pp = q.poll();
            MutableTreeNode leftChild = null, rightChild = null;
            leftChild = new MutableTreeNode(head.data);
            q.add(leftChild);
            head = head.next;
            if (head != null) {
                rightChild = new MutableTreeNode(head.data);
                q.add(rightChild);
                head = head.next;
            }
            parent.left = leftChild;
            parent.right = rightChild;
        }

        return node;
    }

    void inorderTraversal(MutableTreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }
}