class Item{
    int index;
    int value;
    public Item(int i, int v){
        index = i;
        value = v;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Item> stk = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stk.isEmpty() && stk.peek().value < temperatures[i]){
                Item item = stk.pop();
                res[item.index] = i - item.index;
            }
            stk.push(new Item(i, temperatures[i]));
        }
        return res;
    }
}