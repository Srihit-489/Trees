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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = new int[preorder.length];
        for(int i=0;i<preorder.length;i++){
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        return getTree(inorder,preorder,0,preorder.length-1,0);
        
    }
    
    public TreeNode getTree(int[] inorder,int[] preorder,int l,int h,int pos){
        if(l > h)
            return null;
        int rot = preorder[pos];
        int index = Arrays.binarySearch(inorder,rot);
        TreeNode root = new TreeNode(rot);
        root.left = getTree(inorder,preorder,l,index-1,pos+1);
        root.right = getTree(inorder,preorder,index+1,h,pos+index-l+1);
        return root;
        
    }
 
}
