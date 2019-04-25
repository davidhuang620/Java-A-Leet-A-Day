// KEY 1 : pivot is the value, not the index
// KEY 2 : left <= right    instead of left < right
// KEY 3 : low < pivot      instead of low <= pivot 

    public void sortIntegers2(int[] A) {
        
        // return nothing since it is a void function
        if (A == null || A.length == 0){
            return;
        }
        
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int left, int right){
        
        if (left >= right){
            return;
        }
        
        int low = left, up = right;
        // KEY 1 : pivot is the value, not the index
        int pivot = A[(up + low) / 2];
        
        // KEY 2 : low <= up    instead of left < right
        // so that low pointer and up pointer won't overlap, leave the pivot out of the next recursion
        
        // KEY 3 : low < pivot      instead of low <= pivot 
        // so that we won't skip the duplicates and make the whole array more even to avoid worst case
        
        while (low <= up){
            
            // find left index that need to be swapped
            while (low <= up && A[low] < pivot){
                low++;
            }
            
            // find right index that need to be swapped
            while (low <= up && A[up] > pivot){
                up--;
            }
            
            // if statment cuz we are swapping once 
            if (low <= up){
                int temp = A[low];
                A[low] = A[up];
                A[up] = temp;
                low++;
                up--;
            }
        }
        
        // Careful with the boundary to pass in 
        quickSort(A, left, up);
        quickSort(A, low, right);
    
    }
    
