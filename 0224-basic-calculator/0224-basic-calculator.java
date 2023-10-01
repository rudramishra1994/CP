class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        /*
            1. if character is ( or + add it to the stack 
            2. if character is - add it to the stack
            3. if character is a digit concat all digit to get the complete number and add it to the stack
            4. 
         */

        int sign = 1,res =0,operand = 0;        
        for(int i = 0 ; i < s.length() ;i++){
            char ch = s.charAt(i);
            if(ch == '-'){
                res +=sign*operand;
                sign = -1;
                operand = 0;
            }else if(ch =='+'){
                res+=sign * operand;
                sign = 1;
                operand = 0;
            }else if(Character.isDigit(ch)){
                operand = operand*10+(ch-48);
            }else if (ch == '('){
                stack.push(res);
                stack.push(sign);
                operand = 0;sign = 1;res =0;
            }else if (ch == ')') {
                res = res + sign * operand;
                res = res * stack.pop();
                res+=stack.pop();
                //stack.push(res);
                operand = 0;
                //res = 0;
            }
        }

        return res + sign * operand;
        
    }
}