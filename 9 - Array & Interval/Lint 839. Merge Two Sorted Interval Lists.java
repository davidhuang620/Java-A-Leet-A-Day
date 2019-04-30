public class Solution {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        
        if (list1 == null || list1.size() == 0){
            return list2;
        }
        
        if (list2 == null || list2.size() == 0){
            return list1;
        }
        
        List<Interval> ans = new ArrayList<>();
        
        int pt1 = 0, pt2 = 0;
        Interval currInt = list1.get(0).start <= list2.get(0).start 
                        ? list1.get(0) : list2.get(0);
        while(pt1 < list1.size() && pt2 < list2.size()){
            
            Interval int1 = list1.get(pt1);
            Interval int2 = list2.get(pt2);
            
            if (int1.start <= int2.start){
                currInt = merge(currInt, int1, ans);
                pt1++;
            } else {
                currInt = merge(currInt, int2, ans);
                pt2++;
            } 
        }
        
        while (pt1 < list1.size()){
            currInt = merge(currInt, list1.get(pt1++), ans);
        }
        
        while (pt2 < list2.size()){
            currInt = merge(currInt, list2.get(pt2++), ans);
        }
        
        if (currInt != null){
            ans.add(currInt);
        }
        
        return ans;
    }
    
    private Interval merge(Interval int1, Interval int2, List<Interval> ans){
        Interval ret = new Interval(int1.start, 0);
        if (int2.start > int1.end){
                ans.add(int1);
                ret = int2;
            } else {
                ret.end = int2.end <= int1.end ? int1.end : int2.end;
            }
        return ret;
    }
    
}
