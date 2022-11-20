class Solution {
    public int leastInterval(char[] tasks, int n) {
        int cpuTime = 0;//cpu 이용 시간
        int[] alphabetCount = new int['Z' - 'A' + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());//maxHeap
        
        for (char task : tasks) {
            alphabetCount[task - 'A']++;
        }
        
        for (int alphabet : alphabetCount) {
            if (alphabet > 0) {
                pq.add(alphabet);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        while (!pq.isEmpty()) {
            int needTask = n + 1;//겹치지 않는 알파벳들로 만들 수 있는 작업 단위(개수가 모자라면 뒤에 idle이 붙음)
            
            while (!pq.isEmpty() && needTask > 0) {
                q.add(pq.poll() - 1);
                cpuTime++;
                needTask--;
            }
            
            while (!q.isEmpty()) {
                int leftTask = q.poll();
                if (leftTask > 0) {
                    pq.offer(leftTask);
                }
            }
            
            if (pq.isEmpty()) {
                break;
            }
            
            cpuTime += needTask;
        }
    
        
        return cpuTime;
    }
}