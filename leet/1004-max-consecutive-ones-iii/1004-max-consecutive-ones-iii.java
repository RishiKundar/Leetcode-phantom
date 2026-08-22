class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int high = 0;
        int maxLen = 0;
        int zeros = 0;
        while(high < nums.length){
            if(nums[high] == 0){
                zeros++;
            }
            while(zeros > k){
                if(nums[low] == 0){
                    zeros--;
                }
                low++;
            }
            maxLen = Integer.max(maxLen,high-low+1);
            high++;
        }
        return maxLen;
    }
}