class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
         int left = 0;
        int countOnes = 0;
        int n = s.length();
        String ans = "";
        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < n; right++){
            if(s.charAt(right) == '1'){
                countOnes++;
            }

            while(countOnes > k){
                if(s.charAt(left) == '1'){
                    countOnes--;
                }
                left++;
            }

            if(countOnes == k){

                while(s.charAt(left) == '0'){
                    left++;
                }

                int currLen = right - left + 1;
                String currStr = s.substring(left, right+1);

                if(currLen < minLen){
                    minLen = currLen;
                    ans = currStr;
                }

                if(currLen == minLen && currStr.compareTo(ans) < 0){
                    ans = currStr;
                }
            }
        }
        return ans;
    }
}