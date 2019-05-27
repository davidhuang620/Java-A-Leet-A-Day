// Time: O(n), space: O(1), where n = grumpy.length;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if (customers == null || customers.length == 0 || grumpy == null || grumpy.length == 0) return 0;
        
        int sat = 0, sec = 0, max = 0;
        for (int i = 0; i < customers.length; i++){
            sat += grumpy[i] == 0 ? customers[i] : 0;
            sec += grumpy[i] == 1 ? customers[i] : 0;
            if (i >= X) sec -= grumpy[i-X] == 1 ? customers[i-X] : 0;
            max = Math.max(sec, max);
        }
        
        return sat + max;
    }
}




