/*

MEMOIZATION
Use another matric with the same size to record highest steps in each location

Directions
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

*/
class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        if (maze == null || start == null || destination == null
           || maze.length == 0 || maze[0].length == 0
           || start.length == 0 || destination.length == 0){
            return -1;
        }
        
        int[][] dist = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dist[start[0]][start[1]] = 0;        
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            for (int d = 0; d <= 3; d++){
                int locX = loc[0];
                int locY = loc[1];
                int step = 0;
                while (locX >= 0 && locY >= 0 && locX < maze.length && 
                      locY < maze[0].length && maze[locX][locY] != 1){     
                    locX += dirX[d];
                    locY += dirY[d];
                    step++;
                }
                
                int nextX = locX - dirX[d], nextY = locY - dirY[d];
                if (dist[loc[0]][loc[1]]+step-1 < dist[nextX][nextY]){
                    dist[nextX][nextY] = dist[loc[0]][loc[1]] + step-1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        
        return (dist[destination[0]][destination[1]] == Integer.MAX_VALUE)
              ? -1 : dist[destination[0]][destination[1]];
    }
}
