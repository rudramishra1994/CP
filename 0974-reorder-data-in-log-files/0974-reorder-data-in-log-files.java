class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Queue<String> digLogs = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            String s1 = a.substring(a.indexOf(" ")+1);
            String s2 = b.substring(b.indexOf(" ")+1);
            if(!s1.equals(s2)) return s1.compareTo(s2);
            return a.substring(0,a.indexOf(" ")).compareTo(b.substring(0,b.indexOf(" ")));
        });
        for(String s : logs){
            String [] temp = s.split(" ");
            if(Character.isDigit(temp[1].charAt(0))) digLogs.add(s);
            else pq.add(s);
        }
        String[] ans = new String[logs.length];
        for(int i = 0; i < logs.length;) {
            while(!pq.isEmpty()) ans[i++] = pq.poll();
            while(!digLogs.isEmpty()) ans[i++] = digLogs.poll();
        }

        return ans;

    }
}