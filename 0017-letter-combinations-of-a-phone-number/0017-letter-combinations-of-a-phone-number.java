class Solution {
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        String [] characters = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int len = digits.length();
        if(len < 1) return ans;
        char [] ch = new char[len];
        StringBuilder br = new StringBuilder();
        findCombination(digits,characters,0,len,ch); 
        return ans;  
    }
    private void findCombination(String digits,String [] characters,int currPos, int maxLength,char [] ch){
        if(currPos == maxLength) {
            ans.add(new String(ch));
            return;
        }
        int currDigit = digits.charAt(currPos) - 48;
        for(char c : characters[currDigit].toCharArray()){
            ch[currPos] = c;
            findCombination(digits,characters,currPos+1,maxLength,ch);
        }
    }
}