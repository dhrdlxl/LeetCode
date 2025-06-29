class Solution {
    public int maxChunksToSorted(int[] arr) {
        int answer = 1;
        int n = arr.length;
        int[] max = new int[n];
        int[] min = new int[n];

        max[0] = arr[0];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], arr[i]);
        }

        min[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], arr[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (max[i] <= min[i + 1]) {
                answer++;
            }
        }

        return answer;
    }
}