class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> multipleOfK = new HashSet<>();
        for(int num : nums){
            if(num % k == 0){
                multipleOfK.add(num);
            }
        }
        int a = k;
       while(multipleOfK.contains(a)){
           a = a + k;
       }
       return a;
    }
}