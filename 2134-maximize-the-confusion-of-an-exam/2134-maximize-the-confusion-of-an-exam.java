class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int countT = 0;
        int countF = 0;

        for (char alphabet: answerKey.toCharArray()) {
            if (alphabet == 'T') {
                countT++;
            } else {
                countF++;
            }
        }

        if (Math.min(countT, countF) <= k) {
            return answerKey.length();
        }

        return Math.max(getAnswerLength(answerKey, 'T', k), getAnswerLength(answerKey, 'F', k));
    }

    private int getAnswerLength(String key, char target, int k) {
        int answer = 0;
        int left = 0;
        int right = 0;

        while (right < key.length()) {
            if (key.charAt(right) == target) {
                right++;
            } else {
                if (k > 0) {
                    k--;
                    right++;
                } else {
                    while (left < right && key.charAt(left) == target) {
                        left++;
                    }
                    left++;
                    right++;
                }
            }

            answer = Math.max(answer, right - left);
        }

        return answer;
    }
}