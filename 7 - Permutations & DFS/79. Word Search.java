/*

Mark visited so we won't step on visited
Backtrack when search for other options

*/
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 
            || board == null || board.length == 0 || board[0].length == 0){
            return false;
        }   
        
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                    if (helper(r, c, 0, word, board)){
                        return true;
                    }
            }
        }
        return false;
    }
    
    private boolean helper(int r, int c, int index, String word, char[][] board){
        if (index == word.length()){
            return true;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length
            || board[r][c] != word.charAt(index)){
            return false;
        }
        board[r][c] = ' ';
        if (helper(r-1, c, index + 1, word, board) ||
            helper(r+1, c, index + 1, word, board) ||
            helper(r, c-1, index + 1, word, board) ||
            helper(r, c+1, index + 1, word, board))
        {
             return true;
        }
        board[r][c] = word.charAt(index);
        return false;
    }
}
