        /*
        Since each int represent an unique number
        and Since each courses is labeled from 0 to n-1
        It will be efficient for us to use array to store the data
        
        slower && safer: 
        using the fixed size of the array, create a matrix of [numCourses] * [numCourses]
        
        faster && deals with class casting:
        instead of a 2d int matrix, use an ArrayList[] graph = new ArrayList[numCourses];
        but need to deal with (int) casting later 
        */

class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        
        // There are edge cases where prereq is null and there's one class
        // if (prereq == null || prereq.length == 0 || prereq[0].length != 2){
        //     return true;
        // }
        
        int[][] graph = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];
        
        
        for (int[] pair : prereq){
            // java array is initialized to 0            
            // create graph
            graph[pair[1]][pair[0]]++; 
            
            // create indegree 
            degree[pair[0]]++;
        }
        

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++){
            if (degree[i] == 0){
                queue.add(i);
            }
        }
        
        int ansCount = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            ansCount++;
            for (int i = 0; i < numCourses; i++){
                if(graph[node][i] != 0){
                    degree[i]--;
                    if (degree[i] == 0){
                    queue.add(i);
                    }
                }

            }
            
            
        }
        
        return ansCount == numCourses;
        
    }
    
}


// Faster Version
// Be Aware of CASTING !!



class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        
        if (prereq == null || prereq.length == 0 || prereq[0].length != 2){
            return true;
        }
        
        /*
        Since each int represent an unique number
        and Since each courses is labeled from 0 to n-1
        It will be efficient for us to use array to store the data
        */
        
        List[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        
        // Intialize ArrayList in graph
        for (int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        
        for (int[] pair : prereq){
            
            // create graph
            graph[pair[1]].add(pair[0]); 
            
            // create indegree 
            // java array is initialized to 0
            degree[pair[0]]++;
        }
        

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++){
            if (degree[i] == 0){
                queue.add(i);
            }
        }
        
        int ansCount = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            ansCount++;
            int n = graph[node].size();
            for (int i = 0; i < n; i++){
              // CASTING 
                int next = (int)graph[node].get(i);
                degree[next]--;
                if (degree[next] == 0){
                    queue.add(next);
                }
            }
            
            
        }
        
        return ansCount == numCourses;
        
        
    }
    

}
