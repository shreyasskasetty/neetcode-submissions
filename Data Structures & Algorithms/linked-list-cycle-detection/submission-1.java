/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if(head  == null){
            return false;
        }
        if(head.next == null){
            return false;
        }
        ListNode fp = head.next.next;
        ListNode sp = head.next;

        while(fp != null && fp.next != null && fp != sp){
            sp = sp.next;
            fp = fp.next.next;
        }
        return fp == sp;
    }
}
