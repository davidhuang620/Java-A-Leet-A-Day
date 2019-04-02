class Solution {
    public List<Integer> pancakeSort(int[] A) {
        
        List<Integer> ans = new ArrayList<>();
        
        if (A == null || A.length == 0){
            return ans;
        }
        
        int count = A.length;
        while (count > 0){
            
            int max = A[0], maxInd = 1;
            for (int i = 0; i < count; i++){
                if (A[i] >= max){
                    max = A[i];
                    maxInd = i + 1;
                }
            }
            if (maxInd != count){
                ans.add(maxInd);
                flip(A, maxInd);
                ans.add(count);
                flip(A, count);
            }
            count--;
        }
        
        return ans;
    }
    
    private void flip(int[] nums, int k){
        
        int low = 0, up = k - 1;
        while(low < up){
            int temp = nums[low];
            nums[low] = nums[up];
            nums[up] = temp;
            low++;
            up--;
        }
        
    }
    
}
