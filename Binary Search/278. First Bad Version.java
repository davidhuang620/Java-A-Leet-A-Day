/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int low = 1, up = n;
        
        while (low + 1 < up){
            int mid = low + (up - low) / 2;
            if ( isBadVersion(mid)){
                up = mid;
            } else {
                low = mid;
            }
        }
        
        return isBadVersion(low) ? low : up;
        
    }
}
