//BFS approach for flood fill algorithm - first time acceptance

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int source = image[sr][sc];
        boolean visited[][] = new boolean[m][n];

        Queue<int []> queue = new LinkedList<>();

        int x[] = new int [] {0,0,1,-1};
        int y[] = new int [] {1,-1,0,0};

        queue.add(new int [] {sr,sc});

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                int[] point = queue.poll();
                int xPoint = point[0];
                int yPoint = point[1];
                image[xPoint][yPoint] = color;
                visited[xPoint][yPoint] = true;

                for(int j=0;j<4;j++){
                    int newX = xPoint + x[j];
                    int newY = yPoint + y[j];

                    if(newX>=m || newX<0 || newY>=n || newY<0 || visited[newX][newY]
                    || image[newX][newY]!=source){
                        continue;
                    }

                    queue.add(new int [] {newX,newY});
                }
            }
        }
        return image;
    }
}
