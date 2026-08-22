class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int low = 0;
        int n = s.length();
        int maxFreq = 0;
        HashMap<Character,Integer> count = new HashMap<>();
        for(int high = 0; high < n; high++){
            count.put(s.charAt(high),count.getOrDefault(s.charAt(high),0) + 1);
            maxFreq = Integer.max(maxFreq, count.get(s.charAt(high)));

            while((high-low+1) - maxFreq > k){
                count.put(s.charAt(low), count.get(s.charAt(low)) - 1);
                if(count.get(s.charAt(low)) == 0){
                    count.remove(s.charAt(low));
                }
                low++;
            }

            maxLen = Integer.max(maxLen,high-low+1);
        }
        return maxLen;
    }
}