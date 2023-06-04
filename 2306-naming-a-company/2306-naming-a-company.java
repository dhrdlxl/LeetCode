class Solution {
    public long distinctNames(String[] ideas) {
        long answer = 0;
        HashSet<String>[] set = new HashSet[26];
        
        for (int i = 0; i < 26; i++) {
            set[i] = new HashSet<>();
        }
        
        for (String idea : ideas) {
            int index = idea.charAt(0) - 'a';
            set[index].add(idea.substring(1, idea.length()));
        }
        
        for (int i = 0; i < 25; i++) {
            for (int j = i + 1; j < 26; j++) {
                long same = 0;
                for (String idea : set[i]) {
                    if (set[j].contains(idea)) {
                        same++;
                    }
                }
                
                answer += (set[i].size() - same) * (set[j].size() - same) * 2;
            }
        }
        
        return answer;    
    }
}