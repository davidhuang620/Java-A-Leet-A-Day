



/*
MAKING DEEP COPY instead of shallow copy
*/

/*
longer verson with cleaner logic
1. Create every node
2. Add every node to every node's neighbor
*/


class Solution {
    public Node cloneGraph(Node node) {
        
        if (node == null){
            return null;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        HashMap<Node, Node> map = new HashMap<>();        
        
        // Create every new node
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            map.put(temp, new Node(temp.val, new ArrayList<Node>()));
            for (Node nber: temp.neighbors){
                if (!map.containsKey(nber)){
                    queue.add(nber);
                }            
            }
        }
        
        // Add every neighbor to the every neighbor list
        // if it is not allowed to iterate the hashmap, then use the queue and another set to iterate
        for (Node temp: map.keySet()){
            for (Node nber: temp.neighbors){
                map.get(temp).neighbors.add(map.get(nber));
            }
        }
        
        return map.get(node);
    }
}

/*
Cleaner version with more complicated Logic

1. make a mapping from old node -> new node
2. loop through the oldNodes in the queue, while adding oldNode neighbors to the queue
3. while adding oldNode neighbors to the queue, create the newNode neighbors and 
   put it into mapping (oldNode neighbor -> newNode neighbors)
4. add the newNode neighbors to the newNode neighbors list.

Have to make sure to create the new node first, so we can point to the it later, DO NOT point to the old nodes
creating new Node in the map.put() saves a lot of code

*/


class Solution {
        public Node cloneGraph(Node node) {
        
        if (node == null){
            return null;
        }
        
        // A queue to help BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        // Creating Mapping from old node -> new node
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<Node>()));
        
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            
            for (Node nber: temp.neighbors){
            
                // if not exist before, create the nbers 
                if (!map.containsKey(nber)){
                    queue.add(nber);
                    map.put( nber, new Node(nber.val, new ArrayList<Node>()));
                }
                
                // add the nber into the nber list
                map.get(temp).neighbors.add(map.get(nber));
            }
        }
        
        return map.get(node);
    }
}
