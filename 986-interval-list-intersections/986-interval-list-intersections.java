class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> answer = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        //시작점: max
        //끝점: min
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            if (start <= end) { // answer
                answer.add(new int[]{start, end});
            }
            
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else if (firstList[i][1] == secondList[j][1]) {
                i++;
                j++;
            } else if (firstList[i][1] > secondList[j][1]) {
                j++;
            }
        }
        
        return answer.toArray(new int[0][]);
    }
}