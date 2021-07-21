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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        gethigh(root);
        return max;
    }
    
    public int gethigh(TreeNode root){
        if(root.left == null && root.right == null){
            max = Math.max(max,root.val);
            return root.val;
        }
        if(root.left != null && root.right != null){
            int left = gethigh(root.left);
            int right = gethigh(root.right);
            int choice1 = root.val + left+right;
            choice1 = Math.max(root.val,choice1);
            int choice2 = root.val + Math.max(left,right);
            int emergency = Math.max(left,right);
            int result = Math.max(choice1,choice2);
            max = max > result?max:result;
            return root.val + (emergency > 0? emergency : 0);
        }else if(root.left != null && root.right == null){
            int left = gethigh(root.left);
            int result = Math.max(root.val,root.val+left);
            max = max > result?max:result;
            return result;
        }else{
            int right = gethigh(root.right);
            int result = Math.max(root.val,root.val+right);
            max = max > result?max:result;
            return result;
        }
        
        
    }
    
    
    
    
    
}
