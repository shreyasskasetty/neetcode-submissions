class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stk = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        int i = 0;
        for(i = 0; i < n; i++){
            int start = i;
            while(!stk.isEmpty() && stk.peek()[1] >= heights[i]){
                int index = stk.peek()[0];
                int height = stk.peek()[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
                stk.pop();
            }
            int[] item = new int[2];
            item[0] = start;
            item[1] = heights[i];
            stk.push(item);
        }

        while(!stk.isEmpty()){
            int index = stk.peek()[0];
            int height = stk.peek()[1];
            maxArea = Math.max(maxArea, height *(i - index));
            stk.pop();
        }
        return maxArea;
    }
}
