class Solution {
    public String removeDuplicates(String s, int k) {
        int[] arr = new int[s.length()];
        StringBuilder answer = new StringBuilder(s);
        
        for (int i = 0; i < answer.length(); i++) {
            arr[i] = 1;
            
            if (i - 1 >= 0 && answer.charAt(i - 1) == answer.charAt(i)) {
                arr[i] = arr[i - 1] + 1;
            }
            
            if (arr[i] == k) {
                answer.delete(i - k + 1, i + 1);
                i = i - k;
            }
        }
        
        return answer.toString();
    }
}