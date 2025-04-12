class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);

        for (int i = 1; i < n; i++) {
            String s = sb.toString();
            sb = new StringBuilder();
            char before = s.charAt(0);
            int count = 0;

            for (char ch : s.toCharArray()) {
                if (before == ch) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(before);
                    before = ch;
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(before);
        }

        return sb.toString();
    }
}