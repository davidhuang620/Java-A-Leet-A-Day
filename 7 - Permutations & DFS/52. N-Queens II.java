/*

Similar to Queen I

*/
class Solution {
    public int totalNQueens(int n) {
        return helper(n, 0, new ArrayList<Integer>());
    }
    
    private int helper(int n, int row, List<Integer> placement){
        
        if (n == row){ return 1;}
        
        int ans = 0;
        for (int col = 0; col < n; col++){
            if (isValid(row, col, placement)){
                placement.add(col);
                ans += helper(n, row + 1, placement);
                placement.remove(placement.size() - 1);
            }
        }
        return ans;        
    }
    
    private boolean isValid(int row, int col, List<Integer> placement){
        for (int r = 0; r < row; r++){
            int c = placement.get(r);
            if (c == col){
                return false;
            }
            if (c + r == col + row){
                return false;
            }
            if (c - r == col - row){
                return false;
            }
        }
        return true;
    }
    
}
