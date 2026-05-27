class Solution {
    public int countGoodSubstrings(String s) {

        int l = 0;
        int count = 0;

        Map<Character,Integer> hmap = new HashMap<>();

        if(s.length() < 3){
            return 0;
        }

        for(int i = 0; i < 3 ;i++){
            char c = s.charAt(i);
            hmap.put(c,hmap.getOrDefault(c,0)+1);
        }

        if(hmap.size()==3){
            count++;
        }

        for(int i = 3;i<s.length();i++){

            char lc = s.charAt(l);
            char rc = s.charAt(i);

            hmap.put(lc,hmap.get(lc)-1);

            if(hmap.get(lc)==0){
                hmap.remove(lc);
            }
            
            hmap.put(rc,hmap.getOrDefault(rc,0)+1);

            if(hmap.size()==3){
                count++;
            }    
            l++;        
        }

        return count;
    }
}