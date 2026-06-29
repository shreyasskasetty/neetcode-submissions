class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack();
        for(Character c: s.toCharArray()){
            switch(c){
                case '(':
                case '[':
                case '{':
                    stk.push(c);
                    break;
                case ']':
                case '}':
                case ')':
                    if(!stk.isEmpty()){
                        Character stkTop = stk.peek();
                        if(c == '}' && stkTop.equals('{') || c == ']' && stkTop.equals('[') || c == ')' && stkTop.equals('(')){
                            stk.pop();
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                break;
            }
        }
        return stk.isEmpty();
    }
}
