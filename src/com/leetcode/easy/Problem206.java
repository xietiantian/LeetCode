package com.leetcode.easy;

import com.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse a singly linked list.
 * <p>
 * Hint:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Problem206 {

    public ListNode reverseList(ListNode head) {//2ms
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode pointer = head;
        while (pointer != null) {
            list.add(pointer);
            pointer = pointer.next;
        }
        int i = list.size() - 1;
        while (i > 0) {
            list.get(i).next = list.get(--i);
        }
        list.get(0).next = null;
        return list.get(list.size() - 1);
    }

    /**
     * time O(n) space O(1) Recurssion
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        // base case
        if (null == head || null == head.next)
            return head;
        ListNode rest = head.next; // rest of the linked list
        // reversed rest linked list
        ListNode reversedRest = reverseList1(rest);
        rest.next = head; // connect head and rest
        head.next = null;
        return reversedRest;
    }

    /**
     * iterative solution
     */
    public ListNode reverseList2(ListNode head) {//0ms
        ListNode newNext = null;
        ListNode pointer = head;
        ListNode temp;
        while (pointer != null) {
            temp = pointer.next;
            pointer.next = newNext;
            newNext = pointer;
            pointer = temp;
        }
        return newNext;
    }

}
