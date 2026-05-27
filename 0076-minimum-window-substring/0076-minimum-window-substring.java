class Solution {
    public String minWindow(String s, String t) {

        if(t.length()>s.length()){
            return "";
        }

        Map<Character,Integer> tmap = new HashMap<>();

        for(int i = 0;i<t.length();i++){
            char c = t.charAt(i);
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }

        Map<Character,Integer> smap = new HashMap<>();

        int minL = Integer.MAX_VALUE;
        int l = 0;
        int sleft = 0;
        int sright = 0;
        int have = 0;

        for(int r = 0;r<s.length();r++){
            char c = s.charAt(r);

            smap.put(c,smap.getOrDefault(c,0)+1);

            if(tmap.containsKey(c) && smap.get(c).equals(tmap.get(c))){
                have++;
            }

            while(have == tmap.size()){
                if(r-l+1 < minL){
                    minL = r-l+1;
                    sleft = l;
                    sright = r;
                }
                char lc = s.charAt(l);

                smap.put(lc,smap.get(lc)-1);

                if(tmap.containsKey(lc) && smap.get(lc) < tmap.get(lc)){
                    have--;
                }

                l++;

            }
        }
        return minL == Integer.MAX_VALUE ? "" : s.substring(sleft,sright+1);
        
    }
}