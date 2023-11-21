class Solution {

    public void bfs(int curI, int curJ, int[][] visited, int[][] grid) {
        int row = visited.length;
        int col = visited[0].length;
        if (curI == row -1 && curJ == col -1) {
            return;
        }

        for (int i=0; i<4; i++) {
            int nextI = curI;
            int nextJ = curJ;
            if (i == 0) { // right
                nextJ += 1;
            } else if (i == 1) { // down
                nextI += 1;
            }

            if (nextI < 0 || nextJ < 0 || nextI > row - 1 || nextJ > col - 1) {
                continue;
            }

            if (visited[curI][curJ] + grid[nextI][nextJ] < visited[nextI][nextJ]) {
                visited[nextI][nextJ] = visited[curI][curJ] + grid[nextI][nextJ];
                bfs(nextI, nextJ, visited, grid);
            }
        }
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];

        // init
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                visited[i][j] = 40001;
            }
        }

        int curI = 0;
        int curJ = 0;
        int answer = 0;
        visited[0][0] = grid[0][0];
        bfs(curI, curJ, visited, grid);
        return visited[row-1][col-1];
    }
}
