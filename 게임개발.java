import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임개발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        int[][] board = new int[N+1][M+1];

        for(int i=1; i<board.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {1,1,-1,1};
        int[] dy = {-1,1,1,1};

        int[] backX = {1,0,-1,0};
        int[] backY = {0,-1,0,1};

        int[] dd = {3,0,1,2};
        int cnt = 0;

        int x = x1;
        int y = y1;

        while (true) {
            if(board[x-1][y]>0 && board[x+1][y]>0 && board[x][y+1]>0 && board[x][y-1]>0) {
                if(board[x+backX[direction]][y+backY[direction]]!=1) {
                    cnt++;
                }
                break;
            }

            x += dx[direction];
            y += dy[direction];

            if(x<1||y<1||x>N||y>M) {
                x -= dx[direction];
                y -= dy[direction];
                direction = dd[direction];
                continue;
            }else {
                if (board[x][y] > 0) {
                    x -= dx[direction];
                    y -= dy[direction];
                    direction = dd[direction];
                    continue;
                }
            }

            board[x][y] =2;
            cnt++;
        }
    }
}
