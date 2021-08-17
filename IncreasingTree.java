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
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> inorderlist = new ArrayList<TreeNode>();
        inorder(root,inorderlist);
        TreeNode node1 = null;
        TreeNode node2 = null;
        for(int i=1;i<inorderlist.size();i++){
            node1 = inorderlist.get(i-1);
            node2 = inorderlist.get(i);
            node1.left = null;
            node1.right = node2;
        }
        if(node2 != null){
            node2.left = null;
            node2.right = null;
        }
        
        return inorderlist.get(0);
            
        
    }
    
    public void inorder(TreeNode root,List<TreeNode> list){
        if(root == null)
            return;
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
}
