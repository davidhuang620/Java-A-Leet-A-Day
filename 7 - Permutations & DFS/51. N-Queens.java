/*
Best Explaination right here
https://www.youtube.com/watch?v=wGbuCyNpxIg

The overall Time complexity is O(N * N!)
N to check if it is valid, N! for all of the possibilities

The key to check row by row
for every col we check if it is valid
keep a col index array for col index we placed
we continue the path (recursion to the next row)
if we find the way to the end then we add the whole col ind array (with a strPlacement function) to the ans List
last, we backtrack to find the next solution

*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        search(n, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void search(int n, int row,
                        ArrayList<Integer>placement, List<List<String>> ans){
        
        if (row == n){
        // we draw the chess board in the end, to fully utilize col index array - the ArraList<Integer> placement
        // 
            ans.add(strPlacement(placement));
            return;
        }
        
    // placement is a list of Integer that stores every col index we have placed
    // This was we can use O(N) to check if a placement is valid, instead of a nested for loop for O(n^2)
        for (int col = 0; col < n; col++){
            if (isValid(row, col, placement)){
                placement.add(col);
                search(n, row + 1, placement, ans);
                // Backtracking
                placement.remove(placement.size() - 1);
            }
        }
        
    }
    
    private List<String> strPlacement(ArrayList<Integer> placement){
        List<String> ans = new ArrayList<>();
        for (int r = 0; r < placement.size(); r++){
            String str = "";
            for (int c = 0; c < placement.size(); c++){
                str = c != placement.get(r) ? str + "." : str + "Q";          
            }
            ans.add(str);
        }
        return ans;
    }
    
    private boolean isValid(int row, int col, 
                         ArrayList<Integer> placement){
            
        for (int r = 0; r < row; r++){
            // not on the same col
            if (placement.get(r) == col){
                return false;
            }
            // diagonal 
            if (r + placement.get(r) == row + col){
                return false;
            }
            // diagonal
            if (r - placement.get(r) == row - col){
                return false;
            }
        }
        return true;
    }
}
