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
    private int countNodes(TreeNode node, int maxValue){
        if(node == null){
            return 0;
        }
        
        int left = countNodes(node.left, Math.max(node.val, maxValue));
        int right = countNodes(node.right, Math.max(node.val, maxValue));
        if(maxValue <= node.val){
            return 1 + left + right;
        }
        
        
        return left + right;
    }
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countNodes(root, root.val);
    }
}
