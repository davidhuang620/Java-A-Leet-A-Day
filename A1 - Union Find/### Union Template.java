class Solution{

  public void union(int size){
  
    int[] parent = new int[size];
    for (int i = 0; i < size; i++){
      parent[i] = i;
    }
    
  }

  public int find(int x, int[] parent){
  
    if (x != parent[x]){
      // path compression
      parent[x] = find(parent[x], parent);
    }
    return parent[x];
  }

  public void unionAdd(int a, int b, int[] parent){
  
    int aSet = find(a, parent);
    int bSet = find(b, parent);
    if (aSet != bSet){
      parent[bSet] = aSet; 
    }
    
  }

}
