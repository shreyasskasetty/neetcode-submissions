/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> copyMap = new HashMap<>();
        Node curr = head;
        while(curr != null){
            copyMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            copyMap.get(curr).next = copyMap.get(curr.next);
            copyMap.get(curr).random = copyMap.get(curr.random);
            curr = curr.next;
        }
        return copyMap.get(head);
    }
}
