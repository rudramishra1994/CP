class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int l = 0,r=s.length()-1;
        char [] ch = s.toCharArray();
        while(l < r){
            if(vowels.contains(ch[l]) && vowels.contains(ch[r])){
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }else if(vowels.contains(ch[l]) && !vowels.contains(ch[r])){
                r--;
            }else if(!vowels.contains(ch[l]) && vowels.contains(ch[r])){
                l++;
            }else if(!vowels.contains(ch[l]) && !vowels.contains(ch[r])){
                l++;
                r--;
            }
        }

        return new String(ch);

    }
}