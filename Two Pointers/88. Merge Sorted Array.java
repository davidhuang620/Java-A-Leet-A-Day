/*

To merge it in place with O(1) space,
compare for the larger element and replace starting from behind. 

*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if (nums1 == null || nums1.length == 0) {
            return;
        }        
        
        if (nums2 == null || nums2.length == 0){
            return;
        }
        
        int pt1 = m - 1, pt2 = n - 1, arrPt = m + n - 1;
        while(pt1 >= 0 && pt2 >= 0){
            
            if (nums1[pt1] > nums2[pt2]){
                nums1[arrPt] = nums1[pt1];
                pt1--;
                arrPt--;
            } else {
                nums1[arrPt] = nums2[pt2];
                pt2--;
                arrPt--;
            }
            
        }
        
        while (pt2 >= 0) {
            nums1[arrPt] = nums2[pt2];
            pt2--;
            arrPt--;
        }
        
    }
}
