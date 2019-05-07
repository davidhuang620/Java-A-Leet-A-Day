class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int nums1Len = nums1 == null ? 0 : nums1.length;
        int nums2Len = nums2 == null ? 0 : nums2.length;
        
        // both is empty
        if (nums1Len == 0 && nums2Len == 0) return 0;
        
        // the kth element we are looking for 
        int k = (nums1Len + nums2Len) / 2;
        
        if ((nums1Len + nums2Len) % 2 == 0){
            return (findKth(nums1, 0, nums2, 0, k)
                + findKth(nums1, 0, nums2, 0, k + 1)) / 2.0;
        }
        
        return findKth(nums1, 0, nums2, 0, k + 1);    
    }
    
    // k starts with 1 not 0, it's the kth smallest element
    private int findKth(int[] nums1, int ind1, int[] nums2, int ind2, int k){
        // if one array has exhausted, search on the other array
        // notice it is in the middle of the searching
        // it is nums[ind + k - 1] instead of nums[k - 1]
        if (nums1 == null || ind1 >= nums1.length){
            return nums2[ind2 + k - 1];
        }
        if (nums2 == null || ind2 >= nums2.length){
            return nums1[ind1 + k - 1];
        }
        // the next smallest element is now k
        if (k == 1){
            return nums1[ind1] < nums2[ind2] ? nums1[ind1] : nums2[ind2];
        }
        
        // if ind + k/2 - 1 is out of bounds, 
        // we wanna throw away k/2 from the other array
        // since we are only throwing k/2 away, 
        // the kth element is still guaranteed to be in the rest of the 2 arrays
        int Half1 = ind1 + k/2 - 1 < nums1.length ?
            nums1[ind1 + k/2 - 1] 
            : Integer.MAX_VALUE;
        int Half2 = ind2 + k/2 - 1< nums2.length ?
            nums2[ind2 + k/2 - 1] 
            : Integer.MAX_VALUE;
        
        // we throw away k/2 elements from the smaller half, 
        // and we increase the rank of k by k/2 
        return Half1 > Half2 ?
            findKth(nums1, ind1, nums2, ind2 + k/2, k - k/2)
            : findKth(nums1, ind1 + k/2, nums2, ind2, k - k/2);
    }    
}
