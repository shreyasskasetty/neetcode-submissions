class Solution {
    public int lengthOfLongestSubstring(String s) {
        //stores the unique set of characters
        //used to find out duplicates in the sliding window
        if(s.length() ==  0){
            return 0;
        }else if(s.length() == 1){
            return 1;
        }
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 1;
        int n = s.length();
        int maxLen = 0;
        set.add(s.charAt(i));
        while(i < n && j < n){
            //if character at j is already in the set its a duplicate - remove it from i
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            maxLen = Math.max(j - i + 1, maxLen);
            set.add(s.charAt(j));
            j++;
        }
        return maxLen;
    }
}
