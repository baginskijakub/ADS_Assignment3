public class Board {
    private static int size;

    public Board(int size){
        this.size = size;
    }

    // print the final solution matrix
    static void display(int board[][])
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    // function to check whether the position is safe or not 
    static boolean isSafe(int board[][], int row, int col)
    {
        int i, j;
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 1){
                return false;
            }
        }

        for (i = row, j = col; j >= 0 && i < size; i++, j--){
            if (board[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    // The function that solves the problem using backtracking 
    public static boolean solveNQueen(int board[][], int col)
    {
        if (col >= size){
            return true;
        }

        for (int i = 0; i < size; i++) {
            //if it is safe to place the queen at position i,col -> place it
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQueen(board, col + 1))
                    return true;

                //backtrack if the above condition is false
                board[i][col] = 0;
            }
        }
        return false;
    }

    public void solve()
    {
        int row[] = new int[size];
        for (int i = 0; i < size-1; i++){
            row[i] = 0;
        }
        int board[][] = new int[size][size];


        if (!solveNQueen(board, 0)) {
            System.out.print("Solution does not exist");
            return;
        }

        display(board);
    }
} 