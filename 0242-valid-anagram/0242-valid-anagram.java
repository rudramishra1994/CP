class Solution {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int [] f1 = new int [26];
        int [] f2 = new int [26];
        int n = s.length();
        for(int i = 0; i < n ; i++){
            f1[s.charAt(i)-'a']++;
            f2[t.charAt(i)-'a']++;
        }
        return Arrays.equals(f1,f2);
    }
}