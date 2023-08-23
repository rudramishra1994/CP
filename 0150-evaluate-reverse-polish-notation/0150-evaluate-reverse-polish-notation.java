class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operator = new HashSet<>(Arrays.asList("+","-","*","/"));
        Stack<Integer>  stack = new Stack<>();
        for(String token : tokens){
            if(!operator.contains(token)) stack.push(Integer.parseInt(token));
            else {
                int op1 = stack.pop();
                int op2 = stack.pop();
                if(token.equals("+")) {
                    op1 = op1+op2;
                }else if (token.equals("-")){
                    op1 = op2-op1;
                }else if (token.equals("*")){
                    op1 = op1*op2;
                }else {
                    op1 = op2/op1;
                }
                stack.push(op1);
            }
        }

        return stack.pop();
    }
}