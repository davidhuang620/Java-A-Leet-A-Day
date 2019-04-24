/*

Optimized Solution O(n) is hard to think of 

Using heap or sort gives O(nlogn)

*/


class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int pt2 = 0, pt3 = 0, pt5 = 0;
        for (int i = 1; i < n; i++){
            int num = Math.min(Math.min(arr[pt2] * 2, arr[pt3] * 3), arr[pt5] * 5);
            arr[i] = (num);
            if (num == arr[pt2] * 2) pt2++;
            if (num == arr[pt3] * 3) pt3++;
            if (num == arr[pt5] * 5) pt5++;
            
        }
        return arr[n - 1];
    }
}
