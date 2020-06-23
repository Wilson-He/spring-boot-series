package io.wilson.basic.collection;

import java.util.HashMap;

/**
 * @author ex_hewx
 * @date 2020/6/16
 */
public class AVLTree {
    private Node root;

    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            insert(root, val);
        }
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    void insert(Node node, int val) {
        if (node.val == val) {
            return;
        }
        if (val > node.val && node.right == null) {
            node.right = new Node(val, node);
        } else if (val > node.val) {
            insert(node.right, val);
        }
        if (val < node.val && node.left == null) {
            node.left = new Node(val, node);
        } else if (val < node.val) {
            insert(node.right, val);
        }
        node.height = 1 + Integer.max(height(node.left), height(node.right));
    }

    private class Node {
        int height;
        int val;
        Node parent;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            height = 1;
        }

        public Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
        }

        public int balanceFactor() {
            if (left == null && right == null) {
                return 0;
            }
            if (left != null && right == null) {
                return left.height - height;
            }
            if (left == null) {
                return height - right.height;
            }
            return left.height - right.height;
        }


        private Node bstInsert(Node node, int val) {
            return bstInsert(node.left, val);
        }
    }
}
