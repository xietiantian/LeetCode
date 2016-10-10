package com.leetcode.easy;

import com.leetcode.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * <p>
 * Two binary trees are considered equal if they are structurally identical
 * and the nodes have the same value.
 */
public class Problem100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode cur1, cur2;
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            cur1 = stack.pop();
            cur2 = stack.pop();

            //value same?
            if (cur1.val != cur2.val) {
                return false;
            }

            //left same?
            if (cur1.left == null && cur2.left != null) {
                return false;
            } else if (cur1.left != null) {
                if (cur2.left == null) {
                    return false;
                } else {
                    stack.push(cur1.left);
                    stack.push(cur2.left);
                }
            }
            //right same?
            if (cur1.right == null && cur2.right != null) {
                return false;
            } else if (cur1.right != null) {
                if (cur2.right == null) {
                    return false;
                } else {
                    stack.push(cur1.right);
                    stack.push(cur2.right);
                }
            }
        }
        return true;
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        //p!=null && q!=null
        if (p.val != q.val) {
            return false;
        }
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
}
