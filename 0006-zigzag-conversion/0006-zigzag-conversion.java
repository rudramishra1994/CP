class Solution {
    public String convert(String s, int numRows) {
        List<StringBuffer> list = new ArrayList<>();
        if(numRows == 1) return s;
        for(int i = 0 ; i < numRows ;i++) list.add(new StringBuffer());
        int row = 0;
        int index = numRows-1;
        int dir = 1;
        for(int i = 0; i < s.length(); i++){
            
            if(row < numRows){
                if(row == 0) dir =1;
                if(row == numRows -1) dir = -1;
                StringBuffer br = list.get(row);
                br.append(s.charAt(i));
                row = row + dir;
            }

        }
        String ans = "";
        for(StringBuffer br : list){
            ans+=br.toString();
        }

        return ans;
    }   
}