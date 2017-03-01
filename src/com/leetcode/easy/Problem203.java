package com.leetcode.easy;

import com.leetcode.util.ListNode;

/**
 * 203. Remove Linked List Elements
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */

public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {//1ms beats 65.10%
        if (head == null) {
            return null;
        }

        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return null;
            }
        }

        ListNode previous = head;
        ListNode current = head.next;
        while (current != null) {
            if (current.val == val) {//delete current
                current = current.next;
                previous.next = current;
            } else {//move to next node
                previous = current;
                current = current.next;
            }
        }

        return head;
    }
}
