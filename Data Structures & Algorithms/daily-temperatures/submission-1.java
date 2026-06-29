class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stk = new Stack();
        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && temperatures[i] > stk.peek()[1]){
                int[] item = stk.pop();
                res[item[0]] = i - item[0];
            }   
            stk.push(new int[]{i, temperatures[i]});
        }
        return res;
    }
}
