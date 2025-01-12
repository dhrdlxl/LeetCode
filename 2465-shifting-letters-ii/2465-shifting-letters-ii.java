class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] move = new int[n];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];

            if (shift[2] == 1) {
                move[shift[0]]++;
                if (shift[1] + 1 < n) {
                    move[shift[1] + 1]--;
                }
            } else {
                move[shift[0]]--;
                if (shift[1] + 1 < n) {
                    move[shift[1] + 1]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int addCount = 0;

        for (int i = 0; i < n; i++) {
            addCount = (addCount + move[i]) % 26;
            if (addCount < 0) {
                addCount += 26;
            }

            sb.append((char)('a' + (s.charAt(i) - 'a' + addCount) % 26));
        }

        return sb.toString();
    }
}