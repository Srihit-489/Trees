 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
       List<Integer> mylist = new ArrayList<>();
        inorder(root,mylist);
        HashSet<Integer> myhash = new HashSet<>();
        for(int num : mylist){
            if(myhash.contains(k-num))
                return true;
            else
                myhash.add(num);
        }
        return false;
    }
    
  
    
    public void inorder(TreeNode root,List<Integer> mylist){
        if(root == null){
            return;
        }else{
            inorder(root.left,mylist);
            mylist.add(root.val);
            inorder(root.right,mylist);
        }
    }
    
}
