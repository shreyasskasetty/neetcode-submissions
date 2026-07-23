class Solution {
    private HashMap<Character, Integer> createFreqMap(String s){
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(Character c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        return freqMap;
    }
    private boolean checkMatch(HashMap<Character, Integer> f1, HashMap<Character, Integer> f2){
        boolean res = true;
        if(f1.size() == f2.size()){
            for(Character key: f1.keySet()){
                if(!f1.get(key).equals(f2.get(key))){
                    res = false;
                    break;
                }
            }
        }else{
            res = false;
        }
        return res;
    }
    public boolean checkInclusion(String s1, String s2) {
        int l = 0, r = 0;
        boolean res = false;
        int count = 0;
        int windowLen = s1.length();
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> freqMapS1 = createFreqMap(s1);
        HashMap<Character, Integer> freqMapS2 = new HashMap<>();
        for(r = 0; r < s1.length(); r++){
            freqMapS2.put(s2.charAt(r), freqMapS2.getOrDefault(s2.charAt(r), 0) + 1);
        }
        while(r < s2.length()){
            if(checkMatch(freqMapS1, freqMapS2)) return true;
            else{
                freqMapS2.put(s2.charAt(l), freqMapS2.get(s2.charAt(l)) - 1);
                if(freqMapS2.get(s2.charAt(l)).intValue() == 0) freqMapS2.remove(s2.charAt(l));
                l++;
            }
            freqMapS2.put(s2.charAt(r), freqMapS2.getOrDefault(s2.charAt(r), 0) + 1);
            r++;
        }
        if(checkMatch(freqMapS1, freqMapS2)) return true;
        return res;
    }
}
