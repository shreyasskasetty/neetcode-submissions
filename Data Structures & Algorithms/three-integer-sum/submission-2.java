class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>(); 
        List<Integer> numL = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numL);
        for(int i = 0; i < numL.size(); i++){
            int target = -numL.get(i);
            int l = i + 1;
            int r = numL.size() - 1;
            while(l < r){
                if(numL.get(l) + numL.get(r) == target){
                    res.add(Arrays.asList(numL.get(i), numL.get(l), numL.get(r)));
                }
                if(numL.get(l) + numL.get(r) > target){
                    r--;
                }else{
                    l++;
                }
            }         
        }
        return new ArrayList<>(res);
    }
}
