class Solution {
    public int[][] merge(int[][] intervals) {
        int i = 1;
        int n = intervals.length;
        List<int[]> inputArr = new ArrayList<>();
        List<int[]> res = new ArrayList<>();
        for(int t = 0; t < n;t++){
            inputArr.add(intervals[t]);
        }
        inputArr.sort((a, b) -> a[0] - b[0]);
        int[] temp = inputArr.get(0);
        while(i < n){
            if(inputArr.get(i)[0] <= temp[1]){
                temp[0] = Math.min(inputArr.get(i)[0], temp[0]);
                temp[1] = Math.max(inputArr.get(i)[1], temp[1]);
                i++;
            }else{
                res.add(temp);
                temp = inputArr.get(i);
                i++;
            }
        }
        res.add(temp);
        int[][] result = new int[res.size()][2];

        for(int t = 0; t < res.size(); t++){
            result[t] = res.get(t);
        }

        return result;
    }
}
