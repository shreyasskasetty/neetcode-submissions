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
    private void helper(TreeNode root, List<Integer> sortedNums){
        if(root == null){
            return;
        }
        helper(root.left, sortedNums);
        sortedNums.add(root.val);
        helper(root.right, sortedNums);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedNums = new ArrayList<>();
        helper(root, sortedNums);
        return sortedNums.get(k - 1);
    }
}
