/*

Use 2 heap
left Max heap and right Min heap 
This way, we can keep track of the Median all time

*/

class MedianFinder {

    PriorityQueue<Integer> leftMax = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightMin = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
    
        // HAVE TO ADD THIS LINE
        // Need to first dump num into the left then rebalance it
        // since if we directly add number to the right stack
        // there may be number is smaller than the max of left stack stays in the right stack
        // it will mess up the order
        
        leftMax.add(num);
        rightMin.add(leftMax.poll());
        
        // the two only cases are ok:
        //  right size == left size 
        //  right size == left size + 1
        
        if (rightMin.size() > leftMax.size() + 1){
            leftMax.add(rightMin.poll());
        }
    }
    
    public double findMedian() {       
        return rightMin.size() == leftMax.size() ? 
            (leftMax.peek() + rightMin.peek()) / 2.0 : rightMin.peek();
    }
}



/*

Using ArrayList o(n)

*/

class MedianFinder {

    /** initialize your data structure here. */
    ArrayList<Integer> ar;
    public MedianFinder() {
        arr = new ArrayList<>();
    }
    
    public void addNum(int num) {
        for (int i = 0; i < arr.size(); i++){
            if (num < arr.get(i)){
                arr.add(i, num);
                return;
            }
        }
        arr.add(num);
    }
    
    public double findMedian() {
        return arr.size() % 2 == 0 ? 
            (arr.get(arr.size()/2) + arr.get(arr.size()/2-1)) / 2.0
            : arr.get(arr.size()/2) *1.0;
    }
}
