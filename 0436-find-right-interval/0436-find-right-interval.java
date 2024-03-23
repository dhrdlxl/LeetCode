class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] answer = new int[intervals.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] starts = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            map.put(intervals[i][0], i);
        }
        
        Arrays.sort(starts);
        
        for (int i = 0; i < intervals.length; i++) {
            int left = 0;
            int right = starts.length - 1;
            int min = -1;
            boolean isFound = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (starts[mid] >= intervals[i][1]) {
                    min = starts[mid];
                    isFound = true;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            answer[i] = isFound ? map.get(min) : -1;
        }
        
        return answer;
    }
}
