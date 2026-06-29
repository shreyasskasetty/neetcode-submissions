class Solution {
    // checks if the character is an alphabet or
    // a number between 0-9.
    public boolean isAlphaNumeric(char c){
        final int ASCII_ZERO = 48;
        final int ASCII_A = 97;
        int n = c - ASCII_ZERO;
        int a = c - ASCII_A;
        if(n >=0 && n < 9 || a >=0 && a <26){
            return true;
        }
        return false;

    }

    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll(" ", "");
        StringBuilder cs = new StringBuilder();
        System.out.println(str);
        for(char c: str.toCharArray()){
            if(isAlphaNumeric(c)){
                cs.append(c);
            }
        }
        String st = cs.toString();
        int l = 0;
        int r = st.length() - 1;
        System.out.println(cs);
        while(l < r && st.charAt(l) == st.charAt(r)){
            l++;
            r--;
        }
        return l >= r;
    }
}
