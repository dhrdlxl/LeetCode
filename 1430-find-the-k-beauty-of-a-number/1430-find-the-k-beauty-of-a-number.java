class Solution {
    public int divisorSubstrings(int num, int k) {
        int answer = 0;
        String number = Integer.toString(num);

        for (int i = 0; i + k <= number.length(); i++) {
            int guessNumber = Integer.valueOf(number.substring(i, i + k));

            if (guessNumber > 0 && num % guessNumber == 0) {
                answer++;
            }
        }

        return answer;
    }
}