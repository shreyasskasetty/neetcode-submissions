class Solution {
    public int specialArray(int[] nums) {
       int l = 1, r = nums.length;
        while(l <= r){
          int mid = (l + r) / 2;
          int count = 0;
          for(int num: nums){
            if (num >= mid) count++;
          }
          if (count == mid) return mid;
          if(count < mid){
            r = mid - 1;
          }else {
            l = mid + 1;
          }
        }
        return -1;
    }
}