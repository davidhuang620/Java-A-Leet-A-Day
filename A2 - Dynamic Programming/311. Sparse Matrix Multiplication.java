/*

Since, it's spare, record all none 0 for B
And loop through A and the Bnote that are not 0

be prepare to draw chart to clearify the different length and multiplication

The calculation is tricky:

r = A row
c = A col = B row
t = B col

ans[r][t] += A[r][c] * B[c][t];


*/



class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null){
            return null;
        }
        
        List<List<Integer>> Bnote = new ArrayList<>();
        for (int r = 0; r < B.length; r++){
            Bnote.add(new ArrayList<>());
            for (int c = 0; c < B[0].length; c++){
                if (B[r][c] != 0){
                    Bnote.get(r).add(c);
                }
            }
        }
        
        int[][] ans = new int[A.length][B[0].length];
        
        for (int r = 0; r < A.length; r++){
            for (int c = 0; c < A[0].length; c++){
                if (A[r][c] == 0){
                    continue;
                }
                for (int t : Bnote.get(c)){
                    ans[r][t] += A[r][c] * B[c][t];
                }
            }
        }
        
        return ans;
    }
}
