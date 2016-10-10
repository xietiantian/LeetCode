package com.leetcode.easy;

import com.leetcode.util.ListNode;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 */
public class Problem021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {//14ms
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode pre1 = null;
        ListNode cur2 = l2;
        ListNode pre2 = null;
        ListNode temp;

        while (cur1 != null) {
            temp = cur2;
            while (cur2 != null && cur1.val > cur2.val) {
                pre2 = cur2;
                cur2 = cur2.next;
            }
            if (cur2 != temp) {
                if (pre1 != null) {
                    pre1.next = temp;
                } else {
                    l1 = temp;
                }
                pre2.next = cur1;
            }
            pre1 = cur1;
            cur1 = cur1.next;
        }
        if (cur2 != null) {
            pre1.next = cur2;
        }
        return l1;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){//1ms
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
}
