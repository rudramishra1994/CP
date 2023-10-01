class Solution {
    public String intToRoman(int num) {
        Map<Integer,String[]> map = new HashMap<>();
        map.put(10,new String[]{"I","IV","V","IX"});
        map.put(100,new String[]{"X","XL","L","XC"});
        map.put(1000,new String[]{"C","CD","D","CM"});
        map.put(10000,new String[]{"M"});

        int div = 10;int prev = 1;
        
        Stack<String> st = new Stack<>();
        while(num > 0){
            int rem = num % 10;
            num /= 10;
            String [] t = map.get(div);
            StringBuilder res = new StringBuilder();
            while(rem > 0){
                if(rem < 4){
                    res.append(t[0]);
                    rem--;
                }else if(rem == 4){
                    res.append(t[1]);
                    rem = 0;
                }else if(rem == 5){
                    res.append(t[2]);
                    rem = 0;
                }else if(rem == 9){
                    res.append(t[3]);
                    rem = 0;
                }else{
                    res.append(t[2]);
                    rem-=5;
                }
            }
            st.push(res.toString());
            prev = div;
            div = div *10;
        }
       StringBuilder res = new StringBuilder();
       while(!st.isEmpty()) res.append(st.pop());
        return res.toString();
    }
}