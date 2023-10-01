class Solution {
    public int romanToInt(String s) {
       int left = 0, n = s.length()-1;
       Map<Character,Integer> rD = new HashMap<>();
       Map<Character,Set<Character>> nBor = new HashMap<>();
       nBor.put('C',new HashSet<>(Arrays.asList('D','M')));
       nBor.put('X',new HashSet<>(Arrays.asList('L','C')));
       nBor.put('I',new HashSet<>(Arrays.asList('X','V')));
       rD.put('I',1);
       rD.put('V',5);
       rD.put('X',10);
       rD.put('L',50);
       rD.put('C',100);
       rD.put('D',500);
       rD.put('M',1000);
       int res = 0;
       while(left <=n){
            char ch = s.charAt(left);
            if(left == n) return res + rD.get(ch);
            char next = s.charAt(left+1);
            if(ch == 'M' || ch == 'D' || ch == 'V' || ch == 'L') {
                res+=rD.get(ch);
                left++;
                continue;
            }
            if(rD.get(ch) < rD.get(next)) {
                res+=rD.get(next) - rD.get(ch);
                left = left+2;
                continue;
            }
            res+=rD.get(ch);
            left++;
       }
       return res;
    }
}