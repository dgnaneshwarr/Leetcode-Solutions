class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int l = 0;

        int maxS = 0;
        int recoverableC = 0;
        int maxGainWindow = 0;
        

        for(int i = 0;i<customers.length;i++){
            if(grumpy[i]==0){
                maxS += customers[i];
            }
        }

        for(int i =0;i<minutes;i++){
            if(grumpy[i] == 1){
                recoverableC += customers[i];
            }
        }
        
        maxGainWindow = recoverableC;

        for(int i =minutes;i<customers.length;i++){
            if(grumpy[l] == 1){
                recoverableC -= customers[l];
            }
                
            if(grumpy[i] == 1){
                recoverableC += customers[i];
            }
            maxGainWindow = Math.max(maxGainWindow, recoverableC);
            l++;
        }
        
        return maxGainWindow+maxS;

    }
}