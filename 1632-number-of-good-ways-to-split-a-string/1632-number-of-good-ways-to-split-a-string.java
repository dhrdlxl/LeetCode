class Solution {
    public int numSplits(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int[][] count = new int[2][n];

        for (int i = 0; i < n; i++) {
            set.add(s.charAt(i));
            count[0][i] = set.size();
        }

        set = new HashSet<>();

        for (int i = n - 1; i >= 0; i--) {
            set.add(s.charAt(i));
            count[1][i] = set.size();
        }

        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            if (count[0][i] == count[1][i + 1]) {
                answer++;
            }
        }

        return answer;
    }
}