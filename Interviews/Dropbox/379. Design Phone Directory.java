class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    boolean[] phoneUsed;
    Queue<Integer> queue= new LinkedList<>();
    public PhoneDirectory(int maxNumbers) {
        phoneUsed = new boolean[maxNumbers];
        for (int i = 0; i < maxNumbers; i++){
            queue.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (queue.isEmpty()) return -1;
        int num = queue.poll();
        phoneUsed[num] = true;
        return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !phoneUsed[number];
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (phoneUsed[number] == true){
            phoneUsed[number] = false;
            queue.add(number);
        }
    }
}
