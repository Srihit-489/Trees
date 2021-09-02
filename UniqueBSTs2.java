class Solution {
    public List<TreeNode> generateTrees(int n) {
        int[] arr = new int[n];
        for(int i = 0;i < n ; i++){
            arr[i] = i + 1;
        }
        
        return gettree(arr,0,arr.length-1);
    }
    
    public List<TreeNode> gettree(int[] arr,int start,int end){
        if(start > end){
            List<TreeNode> ret = new ArrayList<TreeNode>();
            ret.add(null);
            return ret;
        }
        List<TreeNode> rootlist = new ArrayList<TreeNode>();
        for(int i = start;i<=end;i++){
            // TreeNode root = new TreeNode(arr[i]);
            List<TreeNode> left  = gettree(arr,start,i-1);
            List<TreeNode> right = gettree(arr,i+1,end);
            for(TreeNode lnode : left){
                for(TreeNode rnode : right){
                    TreeNode root = new TreeNode(arr[i]);
                    root.left = lnode;
                    root.right = rnode;
                    rootlist.add(root);
                }
            }
        }
        return rootlist;
    }
}
