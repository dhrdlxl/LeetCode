class Solution {
    private final int ENQUEUE_TIME = 0;
    private final int PROCESSING_TIME = 1;
    private final int INDEX = 2;
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] answer = new int[n];
        int[][] newTasks = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            newTasks[i][ENQUEUE_TIME] = tasks[i][0];
            newTasks[i][PROCESSING_TIME] = tasks[i][1];
            newTasks[i][INDEX] = i;
        }
        
        // 1. 입력값 정렬()
        Arrays.sort(newTasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[ENQUEUE_TIME] == o2[ENQUEUE_TIME]) {
                   return o1[PROCESSING_TIME] - o2[PROCESSING_TIME];
                }
                return o1[ENQUEUE_TIME] - o2[ENQUEUE_TIME];
            }
        });
        
        
        // 2. 우선순위 큐 생성
        PriorityQueue<int[]> processQueue = new  PriorityQueue<>(n, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[PROCESSING_TIME] == o2[PROCESSING_TIME]) {
                    return o1[INDEX] -o2[INDEX];
                }
                return o1[PROCESSING_TIME] - o2[PROCESSING_TIME];
            }
        });
        
        
        // 3. Simulation
        int time = newTasks[0][ENQUEUE_TIME];
        int answerIndex = 0;
        for (int i = 0; i < n; ) {
            while (i < n && newTasks[i][ENQUEUE_TIME] <= time) {
                processQueue.offer(newTasks[i]);
                i++;
            }
            
            if (processQueue.isEmpty()) { // 아직 들어온 task가 없을 때
                time = newTasks[i][ENQUEUE_TIME];
                continue;
            }
            
            int[] finishedTask = processQueue.poll();
            answer[answerIndex] = finishedTask[INDEX];
            answerIndex++;
            time += finishedTask[PROCESSING_TIME];
        }
        
        while (!processQueue.isEmpty()) {
            answer[answerIndex] = processQueue.poll()[INDEX];
            answerIndex++;
        }
        
        
        return answer;
    }
}