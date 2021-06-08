package Exercise4_3;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Miguel Emmara - 18022146
 */

// Java program to flip a binary tree
public class BinaryRotation {

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    // Utility function to create
    // a new Binary Tree Node

    // method to flip the binary tree
    static Node rotateBinaryTree(Node root) {
        // Initialization of pointers
        Node curr = root;
        Node next;
        Node temp = null;
        Node prev = null;

        // Iterate through all left nodes
        while (curr != null) {
            next = curr.left;

            // Swapping nodes now, need
            // temp to keep the previous
            // right child

            // Making prev's right
            // as curr's left child
            curr.left = temp;

            // Storing curr's right child
            temp = curr.right;

            // Making prev as curr's
            // right child
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Iterative method to do
    // level order traversal
    // line by line
    static void printLevelOrder(Node root) {
        // Base Case
        if (root == null) return;

        // Create an empty queue for
        // level order traversal
        Queue<Node> q = new LinkedList<>();

        // Enqueue Root and
        // initialize height
        q.add(root);

        while (true) {
            // nodeCount (queue size)
            // indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;

            // Dequeue all nodes of current
            // level and Enqueue all nodes
            // of next level
            while (nodeCount > 0) {
                Node node = q.peek();
                assert node != null;
                System.out.print(node.data + " ");
                q.remove();

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        Node root = null;

        while (!stop) {
            try {
                System.out.print("Initialize Binary Tree, Input How Many Nodes: ");
                int n = scanner.nextInt();
                scanner.nextLine();

                int i = 1;
                while (i <= n) {
                    try {
                        System.out.print("Please Input Node: ");
                        int node = scanner.nextInt();
                        scanner.nextLine();

                        if (i > 1) {
                            System.out.println("\n1. Left");
                            System.out.println("2. Right");
                            System.out.println("3. Right Left");
                            System.out.println("4. Right Right");
                            System.out.print("\nAnswer: ");
                            int answer = scanner.nextInt();
                            scanner.nextLine();

                            switch (answer) {
                                case 1:
                                    root.left = newNode(node);
                                    break;
                                case 2:
                                    root.right = newNode(node);
                                    break;
                                case 3:
                                    root.right.left = newNode(node);
                                    break;
                                case 4:
                                    root.right.right = newNode(node);
                                    break;
                            }
                        } else {
                            root = newNode(node);
                        }

                        i++;
                    } catch (InputMismatchException e) {
                        System.out.println("\nPlease Input A Valid Number!");
                        scanner.nextLine();
                    }
                }
                stop = true;
            } catch (InputMismatchException e) {
                System.out.println("\nPlease Input A Valid Number!");
                scanner.nextLine();
            }
        }

        /*Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.right.left = newNode(4);
        root.right.right = newNode(5);*/

        System.out.print("Level order traversal " +
                "of given tree\n");
        printLevelOrder(root);

        root = rotateBinaryTree(root);

        System.out.print("\nLevel order traversal " +
                "of the flipped tree\n");
        printLevelOrder(root);
    }

    // A binary tree node
    static class Node {
        int data;
        Node left, right;
    }
}