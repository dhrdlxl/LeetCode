class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> answer = new LinkedList<>();
        int index = 0;
        answer.add(newInterval);
        
        for (int[] interval : intervals) {
            if (interval[0] < newInterval[0] && interval[1] < newInterval[0]) {
                answer.add(index, interval);
                index++;
            } else if (newInterval[1] < interval[0]) {
                answer.addLast(interval);
            }
            
            if (interval[0] <= newInterval[0] && newInterval[0] <= interval[1]) {
                answer.get(index)[0] = interval[0];
            }
            
            if (interval[0] <= newInterval[1] && newInterval[1] <= interval[1]) {
                answer.get(index)[1] = interval[1];
            }
        }
        
        return answer.stream().toArray(int[][]::new);
    }
}