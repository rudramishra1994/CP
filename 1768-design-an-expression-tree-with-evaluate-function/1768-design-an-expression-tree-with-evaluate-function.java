/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
    String val;
    Node left;
    Node right;
};

class BTNode extends Node{

    //private static Set<String> operator = new HashSet<>(Arrays.asList("+","-","*","/"));
    private static String operators = "+-*/";
    BTNode(String val){
        this.val = val;
    }
    BTNode(){
        this.val = null;
    }
    public int evaluate(){
        return DFS(this);
    }
    private int DFS(Node root){
        if(root == null) return 0;
        if(operators.contains(root.val)) 
        {
            int leftTreeValue = DFS(root.left);
            int rightTreeValue = DFS(root.right);
            switch(root.val){
                case "+" : return leftTreeValue + rightTreeValue;
                case "-" : return leftTreeValue - rightTreeValue;
                case "*" : return leftTreeValue * rightTreeValue;
                case "/" : return leftTreeValue / rightTreeValue;
            }
        }
        return Integer.valueOf(root.val); 
       
    }
}




/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        Set<String> operator = new HashSet<>(Arrays.asList("+","-","*","/"));
        for(String s : postfix){
            if(!operator.contains(s)) stack.push(new BTNode(s));
            else{
                Node temp = new BTNode(s);
                temp.right = stack.pop();
                temp.left = stack.pop();
                stack.push(temp);
            }
        }
        return stack.pop();

    }

};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */