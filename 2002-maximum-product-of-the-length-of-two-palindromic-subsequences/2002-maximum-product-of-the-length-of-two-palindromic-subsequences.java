class Solution {
    private int answer = 0;
    private StringBuilder a, b;

    public int maxProduct(String s) {
        a = new StringBuilder();
        b = new StringBuilder();

        find(s, 0);

        return answer;
    }

    private void find(String s, int step) {
        if (step == s.length()) {
            if (a.length() > 0 && b.length() > 0
                && isPalindrom(a) && isPalindrom(b)) {
                answer = Math.max(answer, a.length() * b.length());
            }

            return;
        }

        Character alphabet = s.charAt(step);

        a.append(alphabet);
        find(s, step + 1);
        a.delete(a.length() - 1, a.length());

        b.append(alphabet);
        find(s, step + 1);
        b.delete(b.length() - 1, b.length());

        find(s, step + 1);

        return;
    }

    private boolean isPalindrom(StringBuilder target) {
        int left = 0;
        int right = target.length() - 1;

        while (left < right) {
            if (target.charAt(left) != target.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}