//Problem basically asks to get the shortest path in a binary matrix from top left node to the bottom right node
//we can go in all directions, including all diagonals
//here BFS will work, basically we have to check all paths and the first to reach the target will be returned

class BinaryShortestPath {
    int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // row, col, wt
        grid[0][0] = 1; // Mark the starting cell as visited

        while (queue.size() > 0) {
            int[] peek = queue.remove();
            int row = peek[0];
            int col = peek[1];
            int wt = peek[2];

            if (row == n - 1 && col == n - 1) {
                return wt;
            }

            for (int[] d : dir) {
                int rr = row + d[0];
                int cc = col + d[1];

                if (rr >= 0 && cc >= 0 && rr < n && cc < n && grid[rr][cc] == 0) {
                    queue.add(new int[]{rr, cc, wt + 1});
                    grid[rr][cc] = 1; // Mark the cell as visited
                }
            }
        }
        return -1;
    }
}
