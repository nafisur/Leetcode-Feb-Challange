/*
In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

*/
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if (grid[0][0] != 0 || grid[N-1][N-1] != 0) {
            return -1;
        }
        int len = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        while (!q.isEmpty()) {
            int size = q.size();
            len++;
            for (int i = 0; i < size; i++) {
                int[] n = q.poll();
                int r = n[0], c = n[1];
                if (r == N-1 && c == N - 1) {
                    return len;
                }
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        int nr = r + x;
                        int nc = c + y;
                        if (nr >= 0 && nc >= 0 && nr < N && nc < N && grid[nr][nc] == 0) {
                            grid[nr][nc] = 2;
                            q.add(new int[] {nr, nc});
                        }
                    }
                }
            }
        }
        return -1;
    }
}