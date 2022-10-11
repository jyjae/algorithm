import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 음료수얼려먹기 {
    private static int[][] board;
    private static boolean[][] visit;
    private static int result = 0;
    private static int N;
    private static int M;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j]!=1 && visit[i][j]==false) {
                    result++;
                    dfs(i,j);
                }
            }
        }

        System.out.println(result);

    }

    public static void dfs(int x, int y) {
        for(int i=0; i<dx.length; i++) {
            x += dx[i];
            y += dy[i];

            if(x<0 || y<0 || x>=board.length || y>M) continue;

            if(board[x][y] != 1) {
                if(visit[x][y]==false) {
                    visit[x][y] = true;
                    dfs(x,y);
                }
            }

        }
    }

}
