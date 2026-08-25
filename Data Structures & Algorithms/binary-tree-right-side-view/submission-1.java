/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int s = queue.size();
            TreeNode curr = null;
            for(int i = 0; i < s; i++){
               curr = queue.poll();
               if(curr.left != null)
               queue.offer(curr.left);
               if(curr.right != null)
               queue.offer(curr.right);
            }
            if(curr != null)
            res.add(curr.val);
        }
        return res;
    }
}
