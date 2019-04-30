class Solution {
    public int search(ArrayReader reader, int target) {
        
        if (reader == null){ return -1; }
        
        // boundary check
        if(reader.get(0) == target){ return 0;}
        
        int index = 1;
        
        while (reader.get(index) < target){
            index *= 2;
        }
        
        int low = index / 2, up = index;
        while (low + 1 < up){
            
            int mid = low + (up - low) / 2;
            if(reader.get(mid) == target){
                return mid;
            } else if (reader.get(mid) < target){
                low = mid;
            } else {
                up = mid;
            }    
        }
        
        if (reader.get(low) == target){
            return low;
        }
        if (reader.get(up) == target){
            return up;
        }
        
        return -1;
        
    }
}
