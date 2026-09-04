class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> arr = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            arr.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        while(i < intervals.length && intervals[i][0]<= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        arr.add(new int[]{newInterval[0], newInterval[1]});
        while(i < intervals.length){
            arr.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        int[][] res = new int[arr.size()][2];
        for(int j = 0; j < arr.size();j++){
            res[j] = arr.get(j);
        }
        return res;
    }
}
