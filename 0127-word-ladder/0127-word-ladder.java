class Solution {

    /***
        Plain level-order BFS gives TLE. This happens because we use the entire english alphabet set (26).

     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Map<String,List<String>> intermediateWordMap = preprocessing(wordList);
        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        Queue<Pair<String,Integer>> q= new LinkedList<>();
        q.add(new Pair<>(beginWord,1));
        while(!q.isEmpty()){
            String currWord = q.peek().getKey();
            int currLevel = q.poll().getValue();

            for(int i = 0 ; i < currWord.length();i++){
                StringBuffer br = new StringBuffer();
                br.append(currWord.substring(0,i)).append('*').append(currWord.substring(i+1));
                for(String neighbor : intermediateWordMap.getOrDefault(br.toString(),new ArrayList<>())){
                    if(neighbor.equals(endWord)) return currLevel+1;
                    else if(!seen.contains(neighbor)){
                        seen.add(neighbor);
                        q.add(new Pair<>(neighbor,currLevel+1));
                    }
                }

            }
        }

        return 0;

    }

    private Map<String, List<String>> preprocessing(List<String>wordList){
        Map<String, List<String>> res = new HashMap<>();
        int n = wordList.get(0).length();
        for(String s : wordList){
            for(int i = 0 ; i < n; i++){
                StringBuffer br = new StringBuffer();
                br.append(s.substring(0,i)).append('*').append(s.substring(i+1));
                List<String> temp = res.getOrDefault(br.toString(),new ArrayList<>());
                temp.add(s);
                res.put(br.toString(),temp);
            }
        }
        return res;
    }

}