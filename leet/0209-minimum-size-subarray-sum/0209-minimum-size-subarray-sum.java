class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int high = 0;
        int minLen = Integer.MAX_VALUE;
        int n =  nums.length;
        int sum = 0;
        while(high < n){
            sum = sum + nums[high];
            while(sum >= target){
                int len = high-low+1;
                minLen = Integer.min(minLen,len);
                sum = sum - nums[low];
                low++;
            }
            high++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}