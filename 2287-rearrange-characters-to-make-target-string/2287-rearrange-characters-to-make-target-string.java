class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] count = new int['z' - 'a' + 1];
        int[] countTarget = new int['z' - 'a' + 1];
        int answer = Integer.MAX_VALUE;
        
        for (char alphabet : s.toCharArray()) {
            count[alphabet - 'a']++;
        }
        
        for (char alphabet : target.toCharArray()) {
            countTarget[alphabet - 'a']++;
        }
        
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            if (countTarget[i] > 0) {
                answer = Math.min(answer, count[i] / countTarget[i]);
            }
        }
        
        return answer;
    }
}