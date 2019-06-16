
/*
https://leetcode.com/problems/duplicate-zeros/discuss/313208/Space-O(1)-Detailed-Explanation
*/

// O(1) space
class Solution {
    public void duplicateZeros(int[] arr) {
        
        int pt2 = 0; // figuring out pt2
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == 0) pt2++;
            pt2++;
        }
        
        int pt1 = arr.length - 1;
        pt2--;
        while (pt1 >= 0){
            if (pt2 < arr.length) arr[pt2] = arr[pt1];// assign if pt2 is in range
            pt2--;
            if (arr[pt1] == 0){
                if (pt2 < arr.length) arr[pt2] = 0; // duplicate zeros
                pt2--;
            } 
            pt1--;
        }
        
    }
}


// O(n) space

class Solution {
    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) return;
        
        int[] temp = new int[arr.length];
        for(int i = 0; i < arr.length; i++) temp[i] = arr[i];
        
        int tPt = 0, aPt = 0;
        while (aPt < arr.length){
            if (temp[tPt] == 0){
                arr[aPt++] = 0;
            }
            if (aPt < arr.length){ 
                arr[aPt++] = temp[tPt++];
            }
        }
        
    }
}
