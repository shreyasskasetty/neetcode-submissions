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

    public boolean isValidHelper(TreeNode root, long left, long right){
        if(root == null){
            return true;
        }
        if(!(left < root.val && root.val < right)){
            return false;
        }
        return isValidHelper(root.left, left, root.val) && isValidHelper(root.right, root.val, right);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return isValidHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
