/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Map<Node, Node> hashMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(node);
        hashMap.put(node, new Node(node.val));
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            for(Node neigh: currNode.neighbors){
                if(!hashMap.containsKey(neigh)){
                    Node neighCopy = new Node(neigh.val);
                    hashMap.put(neigh, neighCopy);
                    queue.offer(neigh);
                    hashMap.get(currNode).neighbors.add(neighCopy);
                }else{
                   hashMap.get(currNode).neighbors.add(hashMap.get(neigh));
                }
            }
        }
        return hashMap.get(node);
    }
}