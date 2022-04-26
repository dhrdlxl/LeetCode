/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        
        while (left < right) {
            int version = (int)((left + right) / 2);
            
            if (isBadVersion(version) == false) {
                left = version + 1;
            } else {
                right = version;
            }
        }
        
        return (int)right;
    }
}