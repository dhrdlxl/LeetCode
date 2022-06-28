class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        int misMatchCount = p.length();
        List<Integer> answer = new ArrayList<>();
        
        for (char alpha : p.toCharArray()) {
            if (map.containsKey(alpha)) {
                map.put(alpha, map.get(alpha) + 1);
            } else {
                map.put(alpha, 1);
            }
        }
        
        HashSet<Character> minusAlpha = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i - p.length() >= 0) {
                char expireAlpha = s.charAt(i - p.length());
                if (map.containsKey(expireAlpha)) {
                    map.put(expireAlpha, map.get(expireAlpha) + 1);
                    misMatchCount++;
                    if (map.get(expireAlpha) >= 0 
                        && minusAlpha.contains(expireAlpha)) {
                        minusAlpha.remove(expireAlpha);
                    }
                }
            }
            
            char alpha = s.charAt(i);
            if (map.containsKey(alpha)) {
                map.put(alpha, map.get(alpha) - 1);
                misMatchCount--;
                
                if (map.get(alpha) < 0) {
                    minusAlpha.add(alpha);
                }
            }
            
            if (misMatchCount == 0 && minusAlpha.size() == 0) {
                answer.add(i - p.length() + 1);
            }
        }
        
        return answer;
    }
}