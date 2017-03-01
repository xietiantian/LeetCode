package com.leetcode.easy;

import com.leetcode.util.ListNode;

/**
 * 234. Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class Problem234 {
    public boolean isPalindrome(ListNode head) {//2ms beats 36.77%
        if (head == null) {
            return true;
        }

        ListNode head1 = head;
        ListNode head2 = head.next;
        ListNode fastPointer = head;
        ListNode pre = head;
        //find mid pointer, and reverse head half part
        while (fastPointer.next != null && fastPointer.next.next != null) {
            head1 = head2;
            head2 = head2.next;
            fastPointer = fastPointer.next.next;
            head1.next = pre;
            pre = head1;
        }

        //odd number of elements, need left move head1 one step
        if (fastPointer.next == null) {
            head1 = head1.next;
        }

        //compare from mid to head/tail
        while (head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
}
