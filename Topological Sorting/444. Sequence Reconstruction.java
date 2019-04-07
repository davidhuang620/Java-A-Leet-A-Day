/*

Many Edge cases to consider !!!!!
Mand details to go over !!!

*/
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        
        if (seqs.size() == 0){
            return false;
        }
        
        // Using a HashSet to avoid dupicate edges!!
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>(); 
        HashMap<Integer, Integer> indegree = new HashMap<>();
        
        // The key here is add "everything" into the graph and indegree
        for (List<Integer> seq : seqs){
            if (seq.size() == 1){
                if (!graph.containsKey(seq.get(0))){
                    graph.put(seq.get(0), new HashSet<>());
                    indegree.put(seq.get(0), 0);
                } 
            }
            if (seq.size() > 1){
                for (int i = 0, j = 1; j < seq.size(); i++, j++){
                    int front = seq.get(i);
                    int back = seq.get(j);
                    if (!graph.containsKey(front)){
                        graph.put(front, new HashSet<>());
                        indegree.put(front, 0);
                    } 
                    // graph.get(front).add(back);    
                    if (!graph.containsKey(back)){
                        graph.put(back, new HashSet<>());
                        // back in degree will get added one later
                        // Here is just initializing it if it hasn't already 
                        indegree.put(back, 0);
                    } 
                    // The if statement is to avoid duplicate seqs!!
                    if (!graph.get(front).contains(back)){
                        graph.get(front).add(back);
                        indegree.put(back, indegree.get(back) + 1);
                    }
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        // EDGE CASES 
        // seq only have one element
        // [1]
        // [[1],[1],[1]]
        // It will be more thorough 
        for (int node : graph.keySet()){
            if (indegree.get(node) == 0){
                queue.add(node);
            }
        }
        
        int index = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            // to make sure there's only exactly one way of sorting 
            // The key point of the problem!!
            if (queue.size() != 1){
                return false;
            } 
            int node = queue.poll();
            // compare every elements in org
            // be aware of the out of boudns, index >= org 
            if (index >= org.length && node != org[index++]){
                return false;
            }
            ans.add(node);
            // make sure that it is in the graph first
            // if (graph.containsKey(node)){
                for (int nber : graph.get(node)){
                    indegree.put(nber, indegree.get(nber) - 1);
                    if (indegree.get(nber) == 0){
                        queue.add(nber);
                    }
                }
            // }
            
        }
        
        //[1]
        //[[1],[2,3],[3,2]]
        // There are cases that 
        return ans.size() == org.length && graph.size() == org.length;
            
    }
}
