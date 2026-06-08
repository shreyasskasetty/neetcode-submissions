class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hashTable.get(nums[i]) == null){
                hashTable.put(nums[i], 1);
            }else{
                return true;
            }
        }
        return false;
    }
}