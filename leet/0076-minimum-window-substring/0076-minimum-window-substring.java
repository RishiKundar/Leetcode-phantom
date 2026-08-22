class Solution {
    public String minWindow(String s, String t) {
       if(s.length() < t.length()){
            return "";
        }

        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c,0) + 1);
        }

        int low = 0;
        int formed = 0;
        int start = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        for(int high = 0; high < s.length(); high++){
            char c = s.charAt(high);

            window.put(c, window.getOrDefault(c,0) + 1);

            if(need.containsKey(c) && window.get(c) <= need.get(c)){
                formed++;
            }

            // Window Valid
            while(formed == required){
                // Update minimum answer
                if (high - low + 1 < minLen) {
                    minLen = high - low + 1;
                    start = low;
                }

                char lowChar = s.charAt(low);

                window.put(lowChar, window.get(lowChar) - 1);

                if(need.containsKey(lowChar) && need.get(lowChar) > window.get(lowChar)){
                    formed--;
                }
                low++;
            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}