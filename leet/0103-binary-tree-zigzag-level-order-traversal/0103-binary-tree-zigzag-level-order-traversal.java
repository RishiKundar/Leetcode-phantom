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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return result;
        }
        queue.offer(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> currentList = new ArrayList<>(level);
            for(int i = 0; i < level; i++){
                if(leftToRight){
                    TreeNode currNode = queue.pollFirst();
                    currentList.add(currNode.val);
                    if(currNode.left != null){
                        queue.addLast(currNode.left);
                    }
                    if(currNode.right != null){
                        queue.addLast(currNode.right);
                    }
                }else{
                    TreeNode currNode = queue.pollLast();
                    currentList.add(currNode.val);
                    if(currNode.right != null){
                        queue.addFirst(currNode.right);
                    }
                    if(currNode.left != null){
                        queue.addFirst(currNode.left);
                    }
                }
            }
            leftToRight = !leftToRight;
            result.add(currentList);
        }
        return result;
    }
}