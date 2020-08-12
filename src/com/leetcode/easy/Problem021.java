package com.leetcode.easy;

import com.leetcode.util.ListNode;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 */
public class Problem021 {
    
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){ // 0 ms, faster than 100.00%
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { // 0 ms, faster than 100.00%
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head;
        ListNode p1, p2, p;
        if(l1.val < l2.val) {
            p = head = l1;
            p1 = l1.next;
            p2 = l2;
        }else {
            p = head = l2;
            p2 = l2.next;
            p1 = l1;
        }
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                p.next = p1;
                p = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p2;
                p2 = p2.next;
            }
        }
        if(p1 != null){
            p.next = p1;
        }else if(p2 != null) {
            p.next = p2;
        }
        return head;
    }
}
