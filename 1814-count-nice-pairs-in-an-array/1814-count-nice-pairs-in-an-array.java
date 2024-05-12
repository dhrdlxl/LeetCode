class Solution {
    private final int MAX = 1000000007;
    
    public int countNicePairs(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            int result = num - reverse(num);
            
            if (!map.containsKey(result)) {
                map.put(result, 1);
            } else {
                map.put(result, map.get(result) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            long count = e.getValue();
            
            answer = (answer + (int)(count * (count - 1) / 2 % MAX)) % MAX;
        }
        
        return answer;
    }
    
    private int reverse(int num) {
        int newNum = 0;
        
        while (num > 0) {
            newNum *= 10;
            newNum += (num % 10);
            
            num /= 10;
        }
        
        return newNum;
    }
}