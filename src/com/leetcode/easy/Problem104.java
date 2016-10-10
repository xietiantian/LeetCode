package com.leetcode.easy;

import com.leetcode.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 */
public class Problem104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    // recursion method
    public int maxDepth1(TreeNode root) {//1ms
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // iteration method
    public int maxDepth2(TreeNode root) {//8ms
        int max = 0;
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        path.push(root);
        sub.push(1);
        while (!path.isEmpty()) {
            TreeNode temp = path.pop();
            int tempVal = sub.pop();
            if (temp.left == null && temp.right == null) {
                max = Math.max(max, tempVal);
            } else {
                if (temp.left != null) {
                    path.push(temp.left);
                    sub.push(tempVal + 1);
                }
                if (temp.right != null) {
                    path.push(temp.right);
                    sub.push(tempVal + 1);
                }
            }
        }
        return max;
    }

    // iteration method
    public int maxDepth3(TreeNode root) {
        if (root == null)
            return 0;

        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        stack.push(root);
        int count = 0;

        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size > 0) {
                TreeNode cur = stack.pop();//pop==removeFirst
                if (cur.left != null)
                    stack.addLast(cur.left);//push==addFirst
                if (cur.right != null)
                    stack.addLast(cur.right);
                size--;
            }
            count++;
        }
        return count;
    }

}
