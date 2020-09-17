import java.util.ArrayList;
import java.util.List;

public class Answer37 {
    // store empty positions
    public static List<int[]> empties = new ArrayList<>();

    public static boolean stopFlag = false;
    public static boolean[][] row = new boolean[9][9];
    public static boolean[][] col = new boolean[9][9];
    public static boolean[][][] block = new boolean[3][3][9];

    public static void main(String[] args) {
        // https://leetcode-cn.com/problems/sudoku-solver/

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(board);

        System.out.println();
    }

    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    empties.add(new int[]{i, j});
                    continue;
                }

                int index = board[i][j] - '0' - 1;
                row[i][index] = true;
                col[j][index] = true;
                block[i / 3][j / 3][index] = true;
            }
        }

        dfs(board, 0);
    }

    public static void dfs(char[][] board, int pos) {
        if (pos == empties.size()) {
            stopFlag = true;
            return;
        }

        int[] point = empties.get(pos);
        int i = point[0];
        int j = point[1];

        for (int index = 0; index < 9; index++) {
            if (stopFlag) {
                break;
            }

            if (!row[i][index] && !col[j][index] && !block[i / 3][j / 3][index]) {
                row[i][index] = true;
                col[j][index] = true;
                block[i / 3][j / 3][index] = true;

                board[i][j] = ((char) (index + '0' + 1));
                dfs(board, pos + 1);

                row[i][index] = false;
                col[j][index] = false;
                block[i / 3][j / 3][index] = false;
            }
        }
    }
}