class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack  = new Stack<>();
        Map<Character,Character> mp = new HashMap<>();
        mp.put(')','(');
        mp.put('}','{');
        mp.put(']','[');
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty() ||!(mp.get(c) == stack.pop())) return false;
            }
        }

        return stack.isEmpty();

    }
}