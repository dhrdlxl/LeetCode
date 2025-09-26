class Solution {
    public int countPoints(String rings) {
        int n = rings.length();
        int answer = 0;
        int[] rod = new int[101];

        int num ;
        Character alphabet;
        for (int i = 0; i + 1 < n; i += 2) {
            alphabet = rings.charAt(i);
            num = (int)(rings.charAt(i + 1) - '0');

            if (alphabet == 'R') {
                rod[num] = (rod[num] | 1);
            } else if (alphabet == 'G') {
                rod[num] = (rod[num] | (1 << 1));
            } else if (alphabet == 'B') {
                rod[num] = (rod[num] | (1 << 2));
            }
        }

        for (int i = 0; i <= 100; i++) {
            if (rod[i] == 7) {
                answer++;
            }
        }
        return answer;
    }
}