class Solution {
    public int maxDistToClosest(int[] seats) {
        int answer = 0;
        int index = 0;
        int n = seats.length;

        for (;index < n; index++) {
            if (seats[index] == 1) {
                break;
            }
            answer++;
        }

        int distance = 0;
        for (;index < n; index++) {
            if (seats[index] == 1) {
                answer = Math.max(answer, (distance - 1) / 2 + 1);
                distance = 0;
            } else {
                distance++;
            }
        }

        answer = Math.max(answer, distance);

        return answer;
    }
}