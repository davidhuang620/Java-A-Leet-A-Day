/*

Memoization
2D array x 2 
one for visited
one for memo

*/

class Solution {
    public boolean isMatch(String s, String p) {
     
        if (s == null || p == null){
            return false;
        }
        
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        
        // memoization
        boolean[][] memo = new boolean[s.length()][p.length()];
        // need another 2d array to check if we have visited 
        boolean[][] visited = new boolean[s.length()][p.length()];
        return dfs(sChar, pChar, 0, 0, memo, visited);
            
    }
    
    private boolean dfs(char[] s, char[] p, int sInd, int pInd, 
                        boolean[][] memo, boolean[][] visited){
        
        // case s == "" && ( p == "" or ""*....*" )
        if (sInd == s.length){
            for (int i = pInd; i < p.length; i++){
                if (p[i] != '*'){
                    return false;
                }
            }
            return true;
        }
        
        if (pInd == p.length){
            return false;
        }
        
        if (visited[sInd][pInd] == true){
            return memo[sInd][pInd];
        }
        
        // memo
        boolean res;
        
        if (s[sInd] == p[pInd] || p[pInd] == '?'){
            res = dfs(s, p, sInd + 1, pInd + 1, memo, visited);
        } else if (p[pInd] == '*'){
                    // * == s[sInd] + ...
                    // * == s[sInd]
                    // * == empty string
                res = dfs(s, p, sInd + 1, pInd, memo, visited)         
                    || dfs(s, p, sInd + 1, pInd + 1, memo, visited) 
                    || dfs(s, p, sInd, pInd + 1, memo, visited);    
        } else{
            res = false;
        }
        
        visited[sInd][pInd] = true;
        memo[sInd][pInd] = res;        
        return res;
        
    }
    
}
