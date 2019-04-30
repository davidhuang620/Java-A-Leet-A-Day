        /*
        Since each int represent an unique number
        and Since each courses is labeled from 0 to n-1
        It will be efficient for us to use array to store the data
        
        Ask if it has duplicate edges
        
        BEST faster time & space, safer:
        Use HashMap for graph   -> when we need an arraylist to keep track of every neighbor
        Use int[] for indegree  -> when we know the index is from 0 to n-1 and we just need to store the indegree (int)
        
        
        slower && safer: 
        using the fixed size of the array, create a matrix of [numCourses] * [numCourses]
        
        faster && deals with class casting:
        instead of a 2d int matrix, use an ArrayList[] graph = new ArrayList[numCourses];
        but need to deal with (int) casting later 
        */



// BEST VERSION

class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        
        // There are edge cases where prereq is null and there's one class
        // if (prereq == null || prereq.length == 0 || prereq[0].length != 2){
        //     return true;
        // }

        /*
        Since each int represent an unique number
        and Since each courses is labeled from 0 to n-1
        It will be efficient for us to use array to store the data
        */
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];
        
        
        for (int[] pair : prereq){
            // java array is initialized to 0            
            // create graph
            if (!map.containsKey(pair[1])){
                map.put(pair[1], new ArrayList<>(Arrays.asList(pair[0])));
            } else {
                map.get(pair[1]).add(pair[0]);
            }
            
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
            if (map.containsKey(node)){
                for (int nber : map.get(node)){
                    degree[nber]--;
                    if (degree[nber] == 0){
                    queue.add(nber);
                }

            }
                      
            }
            
        }
        
        return ansCount == numCourses;
   
    }
    

}



// slower version

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
                 // do not support duplicate edges   
                 // cuz we are looping only through i once
                 // but duplicate edges will cause graph[node][i] >= 1
                 // while indegree has counted for the total edges given including the duplicate ones 
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
         
        // There are edge cases where prereq is null and there's one class
//         if (prereq == null || prereq.length == 0 || prereq[0].length != 2){
//             return true;
//         }
        
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
