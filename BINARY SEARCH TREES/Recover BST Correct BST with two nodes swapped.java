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
    TreeNode prev=null;
    TreeNode first=null;
    TreeNode middle=null;
    TreeNode last=null;
    public void inorder(TreeNode root)
    {
        if(root!=null)
        {
            inorder(root.left);
            if(prev!=null && (root.val<prev.val))
            {
                if(first==null)
                {
                    first=prev;
                    middle=root;
                }
                else
                    last=root;
            }
            prev=root;
            inorder(root.right);

        }
    }
    public void swap(TreeNode first,TreeNode last)
    {
        if(first!=null && last!=null)
        {
            int val = first.val;
            first.val = last.val;
            last.val = val;
        }
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(first!=null && last!=null)
            swap(first,last);
        else if(first!=null && middle!=null)
            swap(first,middle);
    }
}
