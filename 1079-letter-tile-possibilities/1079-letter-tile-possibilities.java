class Solution {
    Set<String> answer;
    Map<Character, Integer> map;
    
    public int numTilePossibilities(String tiles) {
        answer = new HashSet<>();
        map = new HashMap<>();
        
        for (char c : tiles.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        
        simulation(0, tiles.length(), new StringBuilder());
        
        return answer.size() - 1;
    }
    
    private void simulation(int step, int end, StringBuilder sequence) {
        if (step == end) {
            answer.add(sequence.toString());
            return;
        }
        
        for (Character key : map.keySet()) {
            int value = map.get(key);
            if (value > 0) {
                map.put(key, value - 1);
                sequence.append(key);

                simulation(step + 1, end, sequence);

                map.put(key, value);
                sequence.deleteCharAt(sequence.length() - 1);
            }
        }
        
        simulation(step + 1, end, sequence);
    }
}