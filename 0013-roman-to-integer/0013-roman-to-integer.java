class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        int before = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        for (Character alphabet : s.toCharArray()) {
            int value = map.get(alphabet);
            
            if (before < value) {
                answer += (value - before * 2);
            } else {
                answer += value;
            }
            
            before = value;
        }
        
        return answer;
    }
}