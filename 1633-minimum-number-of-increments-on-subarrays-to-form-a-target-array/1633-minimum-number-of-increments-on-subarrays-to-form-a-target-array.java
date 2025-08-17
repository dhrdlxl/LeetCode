class Solution {
    public int minNumberOperations(int[] target) {
        int answer = target[0];

        for (int i = 1; i < target.length; i++) {
            answer += Math.max(target[i] - target[i - 1], 0);
        }

        return answer;
    }
}