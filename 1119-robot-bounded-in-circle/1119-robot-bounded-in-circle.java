class Solution {
    public boolean isRobotBounded(String instructions) {
        Map<String,Character> dir_turn = new HashMap<>();
        dir_turn.put("NL",'W');
        dir_turn.put("NR",'E');
        dir_turn.put("SL",'E');
        dir_turn.put("SR",'W');
        dir_turn.put("EL",'N');
        dir_turn.put("ER",'S');
        dir_turn.put("WL",'S');
        dir_turn.put("WR",'N');
        
        Map<Character,int []> dir_xy= new HashMap<>();
        dir_xy.put('N',new int []{0,1});
        dir_xy.put('S',new int []{0,-1});
        dir_xy.put('E',new int []{1,0});
        dir_xy.put('W',new int []{-1,0});
        Set<String> pos = new HashSet<>();
        pos.add("00");
        char currDir = 'N';int x = 0,y = 0;
        for(char ch : instructions.toCharArray() ){
            if(ch == 'G'){
                int [] xy = dir_xy.get(currDir);
                x = x + xy[0];
                y = y + xy[1];
                pos.add(x+""+y);
            }else{
                String nextDir = currDir+""+ch;
                currDir = dir_turn.get(nextDir);
            }
            

        }
        if((x ==0 && y==0)||(currDir!='N')) return true;

        return false;

    }
}