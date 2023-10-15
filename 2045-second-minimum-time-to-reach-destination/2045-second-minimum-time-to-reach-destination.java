class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<Integer> board[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            board[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            board[edge[0]].add(edge[1]);
            board[edge[1]].add(edge[0]);
        }
        
        int[][] v = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            v[i][0] = Integer.MAX_VALUE;
            v[i][1] = Integer.MAX_VALUE;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        v[1][0] = 0;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            int wait = 0;
            if ((node.val / change) % 2 == 1) {
                wait = change - (node.val % change);
            }
            
            int nextVal = node.val + wait + time;
            
            for (int nextNodeIdx : board[node.index]) {
                if (v[nextNodeIdx][0] > nextVal) {
                    v[nextNodeIdx][0] = nextVal;
                    q.offer(new Node(nextNodeIdx, nextVal));
                } else if (nextVal > v[nextNodeIdx][0] && v[nextNodeIdx][1] > nextVal) {
                    if (nextNodeIdx == n) {
                        return nextVal;
                    }
                    
                    v[nextNodeIdx][1] = nextVal;
                    q.offer(new Node(nextNodeIdx, nextVal));
                }
            }
        }
        
        return -1;
    }
    
    class Node {
        int index;
        int val;
        
        Node (int i, int v) {
            this.index = i;
            this.val = v;
        }
    }
}