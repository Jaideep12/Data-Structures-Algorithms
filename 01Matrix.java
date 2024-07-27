class 01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int [][] visited = new int [r][c];
        int [][] result = new int [r][c];

        Queue<int[]> q = new LinkedList<>();

      //We will first mark all 0s as visited and for evert 0 go to nearest 1
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0){
                    q.add(new int [] {i,j,0});
                    visited[i][j]=1;
                }else{
                    visited[i][j]=0;
                }
            }
        }

        int delrow[] = {1,-1,0,0};
        int delcol[] = {0,0,1,-1}; 

        while(!q.isEmpty()){
            int [] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int steps = temp[2];

            result[x][y] = steps;
          //update the steps

            for(int i=0;i<4;i++){
                int nx = x + delrow[i];
                int ny = y + delcol[i];

                //go to all unvisited elements
                if(nx>=0 && nx<r && ny>=0 && ny<c && visited[nx][ny]==0){
                    visited[nx][ny]=1;
                    q.add(new int [] {nx,ny,steps+1});
                }
            }
        }
        return result;
    }
}
