class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j = i; j < heights.length; j++){
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
            
        }
        return maxArea;
    }
}
