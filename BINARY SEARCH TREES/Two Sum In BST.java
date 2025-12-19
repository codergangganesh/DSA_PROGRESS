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
    HashSet<Integer> vals = new HashSet<>();
    boolean result = false;
    public void inorder(TreeNode root ,int k)
    {
        if(root!=null)
        {
            inorder(root.left,k);
            if(vals.contains(k-root.val))
            {
                result=true;
                return;
            }
            else
                vals.add(root.val);
            inorder(root.right,k);
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        inorder(root,k);
        return result;
    }
}