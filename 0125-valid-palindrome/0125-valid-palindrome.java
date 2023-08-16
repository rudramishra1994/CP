class Solution {
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();

        int left = 0 , right = s.length()-1;
        while(left <= right){
            if(!Character.isLetterOrDigit(lowerCase.charAt(left))) {
                left++;continue;
            }
            if(!Character.isLetterOrDigit(lowerCase.charAt(right))){
                right --;
                continue;
            } 

            if(lowerCase.charAt(left)!=lowerCase.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}