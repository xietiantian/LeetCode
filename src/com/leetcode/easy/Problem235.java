package com.leetcode.easy;

import com.leetcode.util.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common
 * ancestor is defined between two nodes v and w as the lowest node in
 * T that has both v and w as descendants (where we allow a node to be
 * a descendant of itself).”
 * <p>
 *        _______6______
 *       /              \
 *   ___2__          ___8__
 *  /      \        /      \
 * 0      _4       7       9
 *       /  \
 *      3   5
 * <p>
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 * Another example is LCA of nodes 2 and 4 is 2, since a node can be a
 * descendant of itself according to the LCA definition.
 */
public class Problem235 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {//8ms
        TreeNode ret = root;
        TreeNode smallNode;
        TreeNode largeNode;
        if (p.val == q.val) {
            return p;
        } else if (p.val > q.val) {
            largeNode = p;
            smallNode = q;
        } else {
            largeNode = q;
            smallNode = p;
        }

        while (largeNode.val < ret.val || smallNode.val > ret.val) {
            while (largeNode.val < ret.val) {
                ret = ret.left;
            }
            while (smallNode.val > ret.val) {
                ret = ret.right;
            }
        }
        return ret;
    }
}
