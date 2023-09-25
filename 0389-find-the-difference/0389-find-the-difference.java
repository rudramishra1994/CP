class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for(int i= 0 ; i< s.length();i++){
            sum -=s.charAt(i);
            sum +=t.charAt(i);
        }
        sum +=t.charAt(t.length()-1);

        return (char)sum;
    }
}