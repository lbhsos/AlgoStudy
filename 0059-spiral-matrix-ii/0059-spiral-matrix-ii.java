class Solution {
    private int RIGHT = 0;
    private int DOWN = 1;
    private int LEFT = 2;
    private int UP = 3;

    public int[][] generateMatrix(int n) {
        // n * n 
        int num = n * n;
        int i=0; 
        int j=0;
        int[][] answer = new int[n][n];
        answer[0][0] = 1;
    
        int direction = RIGHT;
        int idx = 2;
        while (true) {
            if (idx == n*n+1) {
                break;
            }
            Position newPosition = getNextPosition(direction, new Position(i, j));
            if (newPosition.getI() >= n || newPosition.getJ() >= n || newPosition.getI() < 0 || newPosition.getJ() < 0 || answer[newPosition.getI()][newPosition.getJ()] != 0) {
                direction = getNextDirection(direction);
                newPosition = getNextPosition(direction, new Position(i, j));
            }

            i = newPosition.getI();
            j = newPosition.getJ();
            answer[i][j] = idx++;
        }

        return answer;
    }

    public int getNextDirection(int direction) {
        if (direction == RIGHT) {
            return DOWN;
        } else if (direction == DOWN) {
            return LEFT;
        } else if (direction == LEFT) {
            return UP;
        } else {
            return RIGHT;
        }
    }

    public Position getNextPosition(int direction, Position curPos) {
        if (direction == RIGHT) {
            return new Position(curPos.getI(), curPos.getJ()+1);
        } else if (direction == DOWN) {
            return new Position(curPos.getI()+1, curPos.getJ());
        } else if (direction == LEFT) {
            return new Position(curPos.getI(), curPos.getJ()-1);
        } else {
            return new Position(curPos.getI()-1, curPos.getJ());
        }
    }

    class Position {
        int i;
        int j;
        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }
}
