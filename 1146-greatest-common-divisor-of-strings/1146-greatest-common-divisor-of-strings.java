class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equalsIgnoreCase(str2+str1)) return "";
        return str1.substring(0,GCD(str1.length(),str2.length()));
    }

    private int GCD(int len1,int len2){
        for(int i = Math.min(len1,len2); i >=1;i--){
            if(len1%i ==0 && len2%i==0) return i;
        }
        return 1;
    }
}