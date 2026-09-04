class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int[] res = new int[nums.length];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[nums.length - 1] = nums.length - 1;
        for(int i = nums.length - 2; i >=0; i--){
            if(i + nums[i] >= res[Math.min(i + nums[i], nums.length - 1)] | (i + nums[i] >= res[i + 1])){
                res[i] = i;
            }else{
                res[i] = res[i +1];
            }
        }
        for(int i = 0; i < res.length; i++){
            if(res[i] == i){
                System.out.println(i + " : " + "I can reach the end");
            }else{
                System.out.println(i + " : " + "I cannot!");
            }
        }
        return res[0] == 0;
    }
}
