package com.leetcode;

/**
 * Remove Duplicates from Sorted List
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class Problem083 {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {//1ms
        if (head == null) {
            return null;
        }
        int curVal = head.val;
        ListNode curNode = head;
        ListNode curNext = head.next;
        while (curNext != null) {
            if (curNext.val == curVal) {
                curNode.next = curNext.next;
                curNext = curNext.next;
            } else {
                curVal = curNext.val;
                curNode = curNext;
                curNext = curNext.next;
            }
        }

        return head;
    }
}
