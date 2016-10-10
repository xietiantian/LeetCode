package com.leetcode.easy;

import com.leetcode.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 404. Sum of Left Leaves
 * <p>
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 *   3
 *  / \
 * 9  20
 *   /  \
 * 15   7
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 */
public class Problem404 {
    public int sumOfLeftLeaves(TreeNode root) {//8ms
        if (root == null) {
            return 0;
        }
        TreeNode temp = root.left;//减少访问次数 将时间从14ms降到8ms
        if (temp != null && temp.left == null && temp.right == null) {
            return temp.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(temp) + sumOfLeftLeaves(root.right);
        }
    }

    public int sumOfLeftLeaves2(TreeNode root) {//深度优先 9ms
        if (root == null) return 0;
        int ans = 0;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode node;
        TreeNode temp;

        while (!stack.isEmpty()) {
            node = stack.pop();
            temp = node.left;
            if (temp!= null) {
                if (temp.left == null && temp.right == null)
                    ans += temp.val;
                else
                    stack.push(temp);
            }
            temp = node.right;
            if (temp != null) {
                if (temp.left != null || temp.right != null)
                    stack.push(temp);
            }
        }
        return ans;
    }
}
