/*

Think of the process and orders of meetings and rooms.

*/

// Very Greedy, abstract approach

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 
            || intervals[0].length == 0) return 0;
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int rooms = 0, time = start[0], max = 0;
        int sPt = 0, ePt = 0;
        while (sPt < start.length){
            time = start[sPt];
            if (time < end[ePt]){
                rooms++;
                sPt++;
            } else {
                rooms--;
                ePt++;
            }
            max = Math.max(max, rooms);
        }
        
        return max;
    }
}



// heap Approach

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
