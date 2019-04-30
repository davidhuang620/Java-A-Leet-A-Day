/*

Think of the process and orders of meetings and rooms.

*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if (intervals == null) return -1;
        
        Queue<int[]> startHeap = new PriorityQueue<>(
            new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    return a[0] - b[0];   
                }        
            });
        
        for (int[] time : intervals){
            startHeap.add(time);
        }
        
        Queue<int[]> endHeap = new PriorityQueue<>(
            new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    return a[1] - b[1];   
                }        
            });
        
        int max = 0, room = 0;
        
        while(!startHeap.isEmpty()){
            int[] meeting = startHeap.poll();
            while(!endHeap.isEmpty() && meeting[0] >= endHeap.peek()[1]){
                endHeap.poll();
                room--;
            }
            endHeap.add(meeting);
            room++;
            max = Math.max(max, room);
        }
        
        return max;
        
    }
}
