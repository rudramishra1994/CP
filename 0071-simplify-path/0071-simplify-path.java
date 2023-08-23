class Solution {
    public String simplifyPath(String path) {
        String [] words = path.split("/");
        if(words.length ==0) return "/";
        Stack<String> stack = new Stack<>();
        for(String word :words){
            if(word.length() > 0){
                if(stack.isEmpty()) stack.push("/");
                if(!(word.equals("..") || word.equals("."))) {
                    stack.push(word);
                    stack.push("/");
                }
                if(word.equals("..")){
                    if(stack.size()>2){
                        stack.pop();
                        stack.pop();
                    }
                }else if (stack.equals(".")){
                        stack.pop();
                }
            }
            
        }
        if(stack.size()>1 && stack.peek().equals("/")) stack.pop();
        StringBuilder br = new StringBuilder();
        for(String str : stack){
            br.append(str);
        }
        
        return br.toString();

        
    }
}