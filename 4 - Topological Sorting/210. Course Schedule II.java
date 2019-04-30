class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        
        // use hashmap to save time space and no trouble with the int matrix !
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int[] pair : prereq){
            
            if (!map.containsKey(pair[1])){
                map.put(pair[1], new ArrayList<Integer>(Arrays.asList(pair[0])));
            } else {
                map.get(pair[1]).add(pair[0]);
            }
            
            indegree[pair[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0){
                queue.add(i);                
            }
        }
        
        int[] ans = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            ans[index++] = course;
            // There may be cases where node has not nbers and not recorded in the map
            if (map.containsKey(course)){
                for (int next : map.get(course)){
                    indegree[next]--;
                    if (indegree[next] == 0){
                        queue.add(next);
                    }
                }
            }

        }
        
        return index == numCourses ? ans : new int[0];
   
    }
}
