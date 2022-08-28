public class Solution {
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> answer;

    public List<String> findItinerary(List<List<String>> tickets) {
        flights = new HashMap<>();
        answer = new LinkedList<>();
        
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        
        dfs("JFK");
        
        return answer;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        
        answer.addFirst(departure);
    }
}