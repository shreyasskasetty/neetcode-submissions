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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size += 1;
            curr = curr.next;
        }
        System.out.println("List Size: " + size);
        int index = size - n;
        curr = head;
        int i = 0;
        ListNode prev = null;
        while(i < index){
            prev = curr;
            curr = curr.next;
            i++;
        }
        if(prev == null && index == 0){
            head = head.next;
            return head;
        }else{
            prev.next = curr != null?curr.next: null;
        }

        return head;
    }
}
