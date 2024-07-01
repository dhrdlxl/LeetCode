class Solution {    
    public int[] restoreArray(int[][] adjacentPairs) {    
        int[] answer = new int[adjacentPairs.length + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for (int[] pair : adjacentPairs) {
            int num1 = pair[0];
            int num2 = pair[1];
            
            if (!map.containsKey(num1)) {
                map.put(num1, new ArrayList<Integer>());
            }
            map.get(num1).add(num2);
            
            if (!map.containsKey(num2)) {
                map.put(num2, new ArrayList<Integer>());
            }
            map.get(num2).add(num1);
        
            if (set.contains(num1)) {
                set.remove(num1);
            } else {
                set.add(num1);
            }
            
            if (set.contains(num2)) {
                set.remove(num2);
            } else {
                set.add(num2);
            }
        }
        
        int startNum = set.iterator().next();
        answer[0] = startNum;
        answer[1] = map.get(startNum).get(0);
        
        for (int i = 2; i < answer.length; i++) {
            for (int num : map.get(answer[i - 1])) {
                if (num != answer[i - 2]) {
                    answer[i] = num;
                }
            }
        }
        
        return answer;
    }
}