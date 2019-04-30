/* 
Time 
Average: O(nlogn) 
Worst: O(nlogn)

Space
O(n)

Consistency
Yes, duplicate remains order


// Divide them into smaller and smaller pieces until left >= right
// then Merge them together while sorting

*/
public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0){
            return;
        }
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
        
    }
    
    private void mergeSort(int[] A, int left, int right, int[] temp){
            
            if (left >= right){ return; }
            
            int mid = (left + right) / 2;
            mergeSort(A, left, mid, temp);
            mergeSort(A, mid + 1, right, temp);
            merge(A, left, right, temp);
        }
        
    private void merge(int[] A, int left, int right, int[] temp){
        
        int mid = (left + right) / 2;
        int low = left;
        int up = mid + 1;
        int tempPt = left;
        
        while (low <= mid && up <= right){
            temp[tempPt++] = (A[low] <= A[up]) ? A[low++] : A[up++];
        }
        
        while (low <= mid){
            temp[tempPt++] = A[low++];
        }
        
        while (up <= right){
            temp[tempPt++] = A[up++];
        }
        
        for (int i = left; i < right + 1; i ++){
            A[i] = temp[i];
        }
        
    }
    
