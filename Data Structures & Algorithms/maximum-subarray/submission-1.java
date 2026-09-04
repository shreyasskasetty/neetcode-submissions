class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE; 
        int sum =  Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(sum < nums[i] && sum < 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            res = Math.max(sum, res);
        }
        return res;
    }
}
