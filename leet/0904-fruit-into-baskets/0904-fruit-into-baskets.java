class Solution {
    public int totalFruit(int[] fruits) {
        int low = 0;
        int high = 0;
        int maxLen = Integer.MIN_VALUE;
        int n = fruits.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(high = 0; high < n; high ++){
            map.put(fruits[high], map.getOrDefault(fruits[high],0) + 1);
            if(map.size() <= 2){
                maxLen = Integer.max(maxLen,high-low+1);
            }else{
                while(map.size() > 2){
                    map.put(fruits[low], map.get(fruits[low]) - 1);
                    if(map.get(fruits[low]) == 0){
                        map.remove(fruits[low]);
                    }
                    low++;
                }
            }
        }
        return maxLen;
    }
}