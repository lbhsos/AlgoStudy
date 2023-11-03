class Solution {
    private boolean answer = false;

    public boolean find(char[][] board, int i, int j, boolean[][] visited, String word, String curText) {
        if (word.length() <= curText.length()) {
            System.out.println(curText);
            if (word.equals(curText)) {
                answer = true;
            }
            return answer;
        }

        // up, right, down, left
        int[] nextI = {-1, 0, +1, 0};
        int[] nextJ = {0, +1, 0, -1};

        for(int k=0; k<4; k++) {
            int curI = i + nextI[k];
            int curJ = j + nextJ[k];
            if (curI >= 0 && curI < board.length && curJ >=0 && curJ < board[0].length && !visited[curI][curJ]) {
                if (board[curI][curJ] == word.charAt(curText.length())) {
                    visited[curI][curJ] = true;
                    if (find(board, curI, curJ, visited, word, curText + Character.toString(board[curI][curJ]))) {
                        return answer;
                    }
                    visited[curI][curJ] = false;
                }
            }
        }
        return answer;
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                char curChar = board[i][j];
                if (curChar == word.charAt(0)) {
                    visited[i][j] = true;
                    if (find(board, i, j, visited, word, Character.toString(curChar))) {
                        return answer;
                    }
                    visited[i][j] = false;
                }
            }   
        }
        return answer;
    }
}
