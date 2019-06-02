class Solution {
    public void gameOfLife(int[][] board) {
        // 0, 1 = value stays the same
        // 2 = was 0, now 1
        // 3 = was 1, now 0
        
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[r].length; c++){
                int liveNbers = helper(r, c, board);
                if (board[r][c] == 0){
                    board[r][c] = liveNbers == 3 ? 2 : 0;
                } else {
                    board[r][c] = (liveNbers == 2 || liveNbers == 3) ? 1 : -1;
                }
            }
        }
        
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[r].length; c++){
                board[r][c] = board[r][c] >= 1 ? 1 : 0;
            }
        }
        
    }
        
    private int helper(int row, int col, int[][] board){
        int ret = 0;
        for (int r = row - 1; r <= row + 1; r++){
            for (int c = col - 1; c <= col + 1; c++){
                if ((r == row && c == col) || r < 0 || r >= board.length 
                    || c < 0 || c >= board[r].length){
                    continue;
                }
                ret += (board[r][c] == 0 || board[r][c] == 2) ? 0 : 1;
            }
        }
        return ret;
    }
        
} 
