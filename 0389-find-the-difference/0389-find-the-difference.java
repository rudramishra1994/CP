class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0,sum2 =0;
        for(int i= 0 ; i< s.length();i++){
            sum +=s.charAt(i);
            sum2+=t.charAt(i);
        }
        sum2+=t.charAt(t.length()-1);

        return (char)(sum2-sum);
    }
}