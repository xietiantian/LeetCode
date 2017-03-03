package com.leetcode.easy;

import com.leetcode.util.ListNode;

/**
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Problem141 {

    /**
     * Use two pointers, walker and runner.
     * walker moves step by step. runner moves two steps at time.
     * if the Linked List has a cycle walker and runner will meet at some
     * point.
     *
     * @param head head of the LinkedList
     * @return true if the LinkedList has cycle; false otherwise.
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return true;
        }
        return false;
    }
}
