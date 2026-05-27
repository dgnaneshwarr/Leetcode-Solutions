class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int l = 0;
        int r = k;
        int count = 0;
        int sum = 0;

        for(int i = 0;i<k;i++){
            sum += arr[i];
        }

        if(sum/k>=threshold){
            count++;
        }

        for(int i = k;i<arr.length;i++){
            sum = sum - arr[l] + arr[i];
            if(sum/k>=threshold){
                count++;
            }
            l++;
        }
        return count;
    }
}