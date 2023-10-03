class Solution {
    public int largestVariance(String s) {
        // Step 1 find which characters are present in the string and put it in a set.@interface
        char [] ch =s.toCharArray();
        Set<Character> set = s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        int  res =0; 
        boolean firstFound = false;
        for(char c1 : set){
            for(char c2 : set){
                if(c1==c2) continue;
                int f1 = 0, f2 =0;
                for(char c : ch){
                    if(c == c1) f1++;
                    if(c == c2) f2++;
                    if(f2 > 0){
                        res = Math.max(res,f1-f2);
                    }else if(firstFound) res = Math.max(res,f1-1);
                    if(f2 > f1){
                        f1= 0;
                        f2 =0;
                        firstFound = true;
                    }
                }
            }
        }
        return res;

    }
}