class Solution {
    public int maxArea(int[] heights) {
       int l = 0;
       int r = heights.length -1;
       int res = 0;
       while(l < r){
         if(heights[l] < heights[r]){
            res = Math.max(res, heights[l] * (r - l));
            l++;
         }else{
            res = Math.max(res, heights[r]*(r - l));
            r--;
         }
       } 
       return res;
    }
}
