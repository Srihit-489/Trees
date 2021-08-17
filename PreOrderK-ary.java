/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> mylist = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        getlist(root);
        return mylist;
    }
    
    public void getlist(Node root){
        if(root == null)
            return;
        
        mylist.add(root.val);
        for(Node node : root.children)
            getlist(node);
        
        
    }
}
