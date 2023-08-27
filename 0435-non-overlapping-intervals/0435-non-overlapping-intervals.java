class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int answer = 0;
        int start = -50001;
        int end = -50000;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        for (int[] interval : intervals) {
            if (start <= interval[0] && interval[0] < end ) {
                answer++;
                end = Math.min(end, interval[1]);
            } else {
                start = interval[0];
                end = interval[1];
            }
        }
        
        return answer;
    }
}