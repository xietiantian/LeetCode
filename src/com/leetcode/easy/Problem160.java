package com.leetcode.easy;

import com.leetcode.util.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A:          a1 → a2
 * -                   ↘
 * -                    c1 → c2 → c3
 * -                   ↗
 * B:     b1 → b2 → b3
 * <p>
 * begin to intersect at node c1.
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function
 * returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1, p2;
        int len1 = 0;
        int len2 = 0;

        for (p1 = headA; p1 != null; p1 = p1.next) {
            len1++;
        }
        for (p2 = headB; p2 != null; p2 = p2.next) {
            len2++;
        }
        //make sure p1 is shorter than p2
        int i;
        if (len1 > len2) {
            p1 = headB;
            p2 = headA;
            i = len2;
            len2 = len1;
            len1 = i;
        } else {
            p1 = headA;
            p2 = headB;
        }

        for (i = len2; i > len1; i--) {
            p2 = p2.next;
        }

        while (i > 0 && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1 == p2 ? p1 : null;
    }
}
