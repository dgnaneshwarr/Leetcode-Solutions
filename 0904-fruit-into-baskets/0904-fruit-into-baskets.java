class Solution {
    public int totalFruit(int[] fruits) {

        int l = 0;

        int max = 0;

        Map<Integer,Integer> hmap = new HashMap<>();

        for(int r = 0;r<fruits.length;r++){

            hmap.put(fruits[r],hmap.getOrDefault(fruits[r],0)+1);

            if(hmap.size()>2){
                hmap.put(fruits[l],hmap.get(fruits[l])-1);
                if(hmap.get(fruits[l])==0){
                    hmap.remove(fruits[l]);
                }
                l++;
            }

            max = Math.max(max,r-l+1);
        }

        return max;
        
    }
}