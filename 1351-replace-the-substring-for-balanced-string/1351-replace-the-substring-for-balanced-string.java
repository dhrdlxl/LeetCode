class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int appear = n / 4;
        int count[] = new int['Z' + 1];

        for (Character alphabet : s.toCharArray()) {
            count[alphabet]++;
        }

        int answer = n;
        int j = 0;

        for (int i = 0 ; i < n; i++) {
            count[s.charAt(i)]--;

            while (j < n 
                && count['Q'] <= appear
                && count['W'] <= appear
                && count['E'] <= appear
                && count['R'] <= appear) {
                answer = Math.min(answer, i - j + 1);
                count[s.charAt(j)]++;
                j++;
            }
        }
        
        return answer;
    }
}