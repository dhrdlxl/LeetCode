class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] left = new int[100002];
        int[] right = new int[100002];
        
        for (int i = 1; i <= cardPoints.length; i++) {
            left[i] = left[i - 1] + cardPoints[i - 1];
            right[cardPoints.length - i + 1] = right[cardPoints.length - i + 2] + cardPoints[cardPoints.length - i];
        }
        
        if (k >= cardPoints.length) {
            return right[1];
        }
        
        int answer = 0;
        for (int i = 0; i <= k; i++) {
            answer = Math.max(answer, left[i] + right[cardPoints.length - (k - i) + 1]);
        }
        
        return answer;
    }
}