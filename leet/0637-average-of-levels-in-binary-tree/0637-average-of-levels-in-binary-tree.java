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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> doubles = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return doubles;
        }
        queue.offer(root); // 3
        while(!queue.isEmpty()){
            int level = queue.size(); // 1 // 2
            double average = 0; // 0 // 0
            int sum = 0; // 0 // 0
            for(int i = 0; i < level; i++){
                TreeNode currentNode = queue.poll(); // 3 // 9 // 20
                average += currentNode.val; // 3 // 9 + 20 = 29
                if(currentNode.left != null){
                    queue.offer(currentNode.left); // [9] // [15]
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right); // [9, 20] // [15,7]
                }
            }
            average = average / level;
            doubles.add(average);
        }
        return doubles;
    }
}