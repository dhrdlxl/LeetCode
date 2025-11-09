class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int busStop: routes[i]) {
                List<Integer> busRoute = map.getOrDefault(busStop, new ArrayList<>());
                busRoute.add(i);
                map.put(busStop, busRoute);
            }
        }

        if (map.get(source) == null || map.get(target) == null) {
            return -1;
        }

        return bfs(routes, source, target, map);
    }

    private int bfs(int[][] routes, int source, int target, Map<Integer, List<Integer>> map) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        
        q.add(source);
        visited.put(source, 0);

        while (!q.isEmpty()) {
            int cur = q.remove();
            int busCount = visited.get(cur);

            for (int routeNum : map.get(cur)) {
                for (int busStop : routes[routeNum]) {
                    if (busStop == target) {
                        return busCount + 1;
                    } else if (!visited.containsKey(busStop)) {  
                        visited.put(busStop, busCount + 1);
                        q.add(busStop);
                    }
                }
            }
        }

        return -1;
    }
}