class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> robots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }

        robots.sort((a, b) -> a.position - b.position);

        Stack<Robot> rightMovingRobots = new Stack<>();
        List<Robot> remainRobots = new ArrayList<>();

        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                rightMovingRobots.push(robot);
            } else {
                while (!rightMovingRobots.empty()) {
                    Robot right = rightMovingRobots.pop();
                    
                    if (robot.health > right.health) {
                        robot.takeDamage();
                        right.broken();
                    } else if (robot.health < right.health) {
                        right.takeDamage();
                        robot.broken();
                        rightMovingRobots.push(right);
                        break;
                    } else {
                        right.broken();
                        robot.broken();
                        break;
                    }
                }

                if (robot.isAlive()) {
                    remainRobots.add(robot);
                }
            }
        }

        while (!rightMovingRobots.empty()) {
            remainRobots.add(rightMovingRobots.pop());
        }

        return remainRobots.stream()
                    .sorted((a, b) -> a.order - b.order)
                    .map(robot -> robot.health)
                    .toList();
    }

    private class Robot {
        public int position;
        public int health;
        public char direction;
        public int order;

        public Robot(int position, int health, char direction, int order) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.order = order;
        }

        public void takeDamage() {
            this.health--;
        }

        public void broken() {
            this.health = 0;
        }

        public boolean isAlive() {
            return this.health > 0;
        }
    }
}