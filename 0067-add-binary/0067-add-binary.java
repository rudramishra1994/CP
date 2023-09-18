class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder br = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        int x = 0, y =0;
        while(i >=0 || j >=0){
            x= 0;y=0;
            if(i >= 0) x = a.charAt(i--) - 48;
            if(j >= 0) y = b.charAt(j--) - 48;
            int res = (x+y+carry)%2;
            carry = (x+y+carry)/2;
            br.append(res);
        }
        if(carry == 1)br.append(carry);
        return br.reverse().toString();
    }
}