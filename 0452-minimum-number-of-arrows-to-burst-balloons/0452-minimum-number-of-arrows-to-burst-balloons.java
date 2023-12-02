class Solution {
    public int findMinArrowShots(int[][] points) {
        int answer = 0;
        
        Arrays.sort(points, (a, b) -> {
            if (a[0] > b[0]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            } else {
                if (a[1] > b[1]) {
                    return 1;
                } else if(a[1] < b[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }});
        
        for(int i = 0; i < points.length; i++) {
            answer++;
            int minEnd = points[i][1];
            
            while(i + 1 < points.length && points[i + 1][0] <= minEnd) {
                minEnd = Math.min(minEnd, points[i + 1][1]);
                i++;
            }
        }
        
        return answer;
    }
}