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
    // private void print(ListNode head){
    //     ListNode curr = head;
    //     while(curr != null){
    //         System.out.print(curr.val + " ");
    //         curr = curr.next;
    //     }
    // }
    public void reorderList(ListNode head) {
        ListNode second = null;
        ListNode fastPtr = head.next;
        ListNode slowPtr = head;
        //1. Find mid point
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        second = slowPtr.next;

        ListNode prev =  slowPtr.next = null;
        //2. Reverse the second half of list
        while(second != null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        // print(prev);
        //3. Merge
        second = prev;
        ListNode first = head;
        while(second != null && first != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }

    }
}
