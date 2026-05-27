class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0;

        int maxL = 0;
        int maxF = 0;


        Map<Character,Integer> hmap = new HashMap<>();

        for(int r = 0; r<s.length();r++){

            char c = s.charAt(r);

            hmap.put(c,hmap.getOrDefault(c,0)+1);
            maxF = Math.max(maxF,hmap.get(c));

            while((r-l+1)-maxF > k){
                char lc = s.charAt(l);
                hmap.put(lc,hmap.get(lc)-1);
                l++;
            } 
            maxL = Math.max(maxL,r-l+1);

        }

        return maxL;
        
    }
}