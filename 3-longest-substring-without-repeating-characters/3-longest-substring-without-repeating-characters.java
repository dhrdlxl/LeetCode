class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        
        for (int end = 0; end < s.length(); end++) {
            Character alphabet = s.charAt(end);
            
            if (map.containsKey(alphabet) && begin < map.get(alphabet) + 1) {
                    begin = map.get(alphabet) + 1;    
            }
            
            map.put(alphabet, end);
            
            
            if (answer < end - begin + 1) {
                answer = end - begin + 1;
            }
        }
        
        return answer;
    }
}