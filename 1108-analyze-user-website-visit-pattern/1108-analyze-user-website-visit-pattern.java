class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, List<Pair<String,Integer>>> mp = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            mp.putIfAbsent(username[i],new ArrayList<>());
            mp.get(username[i]).add(new Pair<>(website[i],timestamp[i]));
        }

        for(Map.Entry<String,List<Pair<String, Integer>>> entry : mp.entrySet()){
            List<Pair<String,Integer>> value = entry.getValue();
            value.sort((a,b) ->a.getValue() - b.getValue());
        }
        Map<List<String>,Integer> counter = new HashMap<>();
        for(Map.Entry<String,List<Pair<String, Integer>>> entry: mp.entrySet()){
            List<Pair<String, Integer>> userWebsite = entry.getValue();
            Set<String> s = new HashSet<>();
            for(int i = 0 ; i < userWebsite.size() ;i++){
                for(int j = i+1 ; j < userWebsite.size() ;j++){
                    for(int k = j+1; k < userWebsite.size();k++){

                        List<String> key = new ArrayList<>(Arrays.asList(userWebsite.get(i).getKey(),userWebsite.get(j).getKey(),userWebsite.get(k).getKey()));
                        if(s.contains(key.toString())) continue;
                        s.add(key.toString());
                        counter.putIfAbsent(key,0);
                        int value = counter.get(key);
                        counter.put(key,value+1);
                    }
                }
            }
        }
        int max = 0;
        List<String>maxPattern = new ArrayList<>();
        for(Map.Entry<List<String>,Integer> entry : counter.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                maxPattern = entry.getKey();
            }else if (entry.getValue() == max){
                if(maxPattern.toString().compareTo(entry.getKey().toString()) > 0){
                    maxPattern = entry.getKey();
                }
            }
        }
        return maxPattern;

    }
}