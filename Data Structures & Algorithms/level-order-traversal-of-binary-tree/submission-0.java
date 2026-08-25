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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); 
        res.add(new ArrayList<>(List.of(root.val)));
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> row = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode curr = queue.poll();
                if(curr != null){
                    if(curr.left != null){
                        queue.offer(curr.left);
                        row.add(curr.left.val);
                    }
                    if(curr.right != null){
                        queue.offer(curr.right);
                        row.add(curr.right.val);
                    }
                }
            }
            if(row.size() > 0)
                res.add(row);
        }
        return res;
    }
}
