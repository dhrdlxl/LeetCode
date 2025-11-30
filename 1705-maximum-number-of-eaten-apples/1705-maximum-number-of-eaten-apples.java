class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int appleExistDay = 0;
        int answer = 0;
        int n = apples.length;
        PriorityQueue<Apple> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int apple = apples[i];
            int rotDay = days[i];

            if (apple != 0) {
                pq.offer(new Apple(apple, i + rotDay - 1));
            }
            
            if (canEatApple(pq, i)) {
                answer++;
            }
        }

        int maxDay = n;
        while (pq.size() > 0) {
            if (canEatApple(pq, maxDay)) {
                answer++;
            }
            
            maxDay++;
        }

        return answer;
    }

    private boolean canEatApple(PriorityQueue<Apple> pq, int day) {
        while (pq.size() > 0 && pq.peek().rotDay < day) {
                pq.poll();
            }

            if (pq.size() > 0) {
                Apple targetApple = pq.poll();

                if (targetApple.appleCount - 1 > 0 && targetApple.rotDay > day) {
                    pq.offer(new Apple(targetApple.appleCount - 1, targetApple.rotDay));
                }
                return true;
            }

            return false;
    }

    public class Apple implements Comparable<Apple> {
        public int appleCount;
        public int rotDay;

        public Apple(int appleCount, int rotDay) {
            this.appleCount = appleCount;
            this.rotDay = rotDay;
        }

        @Override
        public int compareTo(Apple next) {
            return this.rotDay - next.rotDay;
        }
    }
}