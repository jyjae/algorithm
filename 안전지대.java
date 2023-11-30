public class 안전지대 {
    private boolean[][] visited;
    private int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
    private int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
    int cnt = 0;
    public int solution(int[][] board) {
        int answer = 0;
        int x = board.length;
        visited = new boolean[x][x];

        for( int i=0; i<x; i++) {
            for(int j=0; j<x; j++) {
                if(board[i][j]==1) {
                    visited[i][j] = true;
                    cnt ++;
                    dfs(board, i, j);
                }
            }
        }

        answer = (x*x)-cnt;

        return answer;
    }

    private void dfs(int[][] board, int i, int j) {
        for(int k=0; k<dx.length; k++) {
            int x1 = i+dx[k];
            int y1 = j+dy[k];

            if( x1>=0 && y1>=0 && x1<board.length && y1<board.length) {
                if (!visited[x1][y1] && board[x1][y1] == 0) {
                    visited[x1][y1] = true;
                    cnt++;
                }
            }


        }
    }

    public static void main(String[] args) {
        안전지대 a = new 안전지대();
        int[][] board = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};

        System.out.println(a.solution(board));
    }
}

/*
{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}}	16
[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]	13
{{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}}
 */
