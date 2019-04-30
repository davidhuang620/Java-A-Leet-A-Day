class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        
        int start = 0, end = row * column - 1;
        
        while(start + 1 < end){
            
            int mid = start + (end - start) / 2;
            int number = matrix[mid / column][mid % column];
            
            if(number == target){
                return true;
            }else if(number > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        return ( matrix[start / column][start % column] == target || 
                matrix[end / column][end % column] == target) ? true : false;

    }
}
