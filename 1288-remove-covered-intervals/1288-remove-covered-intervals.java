import java.util.*;

class Solution {    
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                
                return o1[0] - o2[0];
            }
        });
        
        
        int prevRight = 0;
        int answer = intervals.length;
        
        for (int[] cur : intervals) {
            int curRight = cur[1];
            if (curRight <= prevRight) {
                answer--;
            } else {
                prevRight = curRight;
            }
        }
        
        return answer;
    }
}