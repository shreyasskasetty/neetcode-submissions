class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while(l < r){
            int t = numbers[l] + numbers[r];
            if(t == target){
                return new int[]{l + 1, r + 1};
            }
            if(t < target){
                l++;
            }else{
                r --;
            }

        }

        return new int[]{};
    }
}
