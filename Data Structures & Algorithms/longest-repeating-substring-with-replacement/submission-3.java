class Solution {

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freqCount = new HashMap<>();
        int l = 0;
        int res = 0;
        int maxf = 0;
        for(int r = 0; r < s.length(); r++){
            freqCount.put(s.charAt(r), freqCount.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, freqCount.get(s.charAt(r)));
            while((r - l + 1) - maxf > k){
                freqCount.put(s.charAt(l), freqCount.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
