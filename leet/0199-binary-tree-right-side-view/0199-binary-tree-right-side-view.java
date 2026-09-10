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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int level = deque.size();
            for(int i = 0; i < level; i++){
                TreeNode currNode = deque.poll();
                if(i == level-1){
                    result.add(currNode.val);
                }
                if(currNode.left != null){
                    deque.offer(currNode.left);
                }
                if(currNode.right != null){
                    deque.offer(currNode.right);
                }
            }
        }
        return result;
    }
}