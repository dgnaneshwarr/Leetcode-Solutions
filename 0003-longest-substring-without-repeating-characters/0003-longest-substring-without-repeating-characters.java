class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int l = 0;

        int maxL = 0;

        Map<Character,Integer> hmap = new HashMap<>();

        for(int r = 0;r<s.length();r++){

            char c = s.charAt(r);

            if(hmap.containsKey(c)){
                l = Math.max(l, hmap.get(c) + 1);
            }
            hmap.put(c,r);
            maxL = Math.max(maxL,r-l+1);
        }

        return maxL;
    }
}