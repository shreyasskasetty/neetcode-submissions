class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = 1;
        int minProduct = 1;

        // three cases
        //1. if the number is 0 then the subarray product basically restarts
        //2. maxProduct will carry the max product until that point
        //3. minProduct will contain the min product until that point. This case is important because if nums[i] is negative and minProduct is negative. The product of the two will be positive and possibly a high number
        int res = nums[0]; 
        for(int i = 0; i < nums.length; i++){
            int tmp = nums[i]*maxProduct;
            maxProduct = Math.max(Math.max(nums[i]*maxProduct, nums[i] * minProduct), nums[i]);
            minProduct = Math.min(Math.min(tmp, nums[i] * minProduct),nums[i]);
                res = Math.max(res, maxProduct);
        }
        return res;
    }
}