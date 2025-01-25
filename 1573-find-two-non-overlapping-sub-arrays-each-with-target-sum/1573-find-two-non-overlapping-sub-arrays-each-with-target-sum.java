class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int answer = Integer.MAX_VALUE;
        int n = arr.length;
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
        int[] minLength = new int[n];
        Arrays.fill(minLength, Integer.MAX_VALUE);

        for (; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                if (left > 0 && minLength[left - 1] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, minLength[left - 1] + right - left + 1);
                }

                min = Math.min(min, right - left + 1);
            }

            minLength[right] = min;
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}