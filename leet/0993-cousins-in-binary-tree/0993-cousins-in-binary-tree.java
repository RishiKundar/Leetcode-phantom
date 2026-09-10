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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root,y);

        return (
                level(root,xx,0) == level(root,yy,0) && (!isSiblings(root,xx,yy))
                );

    }

    private boolean isSiblings(TreeNode root, TreeNode xx, TreeNode yy) {
        if(root == null){
            return false;
        }
        
        return (
                (root.left == xx && root.right == yy) || (root.left == yy && root.right == xx) 
                || isSiblings(root.left,xx,yy) || isSiblings(root.right,xx,yy)
                );
        
    }

    private int level(TreeNode root, TreeNode xx, int lev) {
        if(root == null){
            return 0;
        }
        if(root == xx){
            return lev;
        }
        int leftLevel = level(root.left,xx,lev+1);
        if(leftLevel != 0){
            return leftLevel;
        }
        return level(root.right,xx,lev+1);
    }

    private TreeNode findNode(TreeNode root, int x) {
        if(root == null){
            return null;
        }
        if(root.val == x){
            return root;
        }

        TreeNode left = findNode(root.left,x);
        if(left != null){
            return left;
        }
        return findNode(root.right,x);
    }
}