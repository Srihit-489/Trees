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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = getTree(nums,0,nums.length-1);
        return root;
    }
    
    public TreeNode getTree(int[] nums,int l,int h){
        if(l > h)
            return null;
        int maxind = getmax(nums,l,h);
        TreeNode root = new TreeNode(nums[maxind]);
        root.left = getTree(nums,l,maxind-1);
        root.right = getTree(nums,maxind+1,h);
        return root;
        
    }
    
    public int getmax(int[] nums,int l,int h){
        int max = Integer.MIN_VALUE;
        int ind = 0;
        for(int i=l;i<=h;i++){
            if(max < nums[i]){
                max = nums[i];
                ind = i;
            }
        }
        return ind;
    }
}
