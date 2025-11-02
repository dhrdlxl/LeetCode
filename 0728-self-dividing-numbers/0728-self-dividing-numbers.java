class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> answer = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            int num = i;
            boolean isDivided = true;

            while (num > 0) {
                if (num % 10 == 0 || i % (num % 10) != 0) {
                    isDivided = false;
                }

                num /= 10;
            }

            if (isDivided) {
                answer.add(i);
            }
        }

        return answer;
    }
}