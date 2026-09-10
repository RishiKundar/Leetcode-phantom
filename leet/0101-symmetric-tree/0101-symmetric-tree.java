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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root.left);
        deque.offerLast(root.right);

        while(!deque.isEmpty()){
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();

            if(left == null && right == null){
                continue;
            }

            if(left == null || right == null || left.val != right.val){
                return false;
            }

            deque.offerLast(left.left);
            deque.offerFirst(right.right);

            deque.offerLast(left.right);
            deque.offerFirst(right.left);
        }
        return true;
    }
}