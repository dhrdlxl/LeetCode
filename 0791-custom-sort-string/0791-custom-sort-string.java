class Solution {
    public String customSortString(String order, String s) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (Character alphabet : order.toCharArray()) {
            map.put(alphabet, 0);
        }
        
        for (Character alphabet : s.toCharArray()) {
            if (map.containsKey(alphabet)) {
                map.put(alphabet, map.get(alphabet) + 1);
            } else {
                answer.append(alphabet);
            }
        }
        
        for (Character alphabet : order.toCharArray()) {
            int count = map.get(alphabet);
            
            while (count > 0) {
                answer.append(alphabet);
                count--;
            }
        }
        
        return answer.toString();
    }
}