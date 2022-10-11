import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열사이클 {
    private static int[][] board;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        while (num>0) {
            num--;
            int result = 0;
            int N = Integer.parseInt(br.readLine());
            board = new int[2][N];
            visit = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<board[0].length; i++) {
                board[0][i] = i+1;
                board[1][i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<N; i++) {
                if(dfs(0,i)) {
                    result++;
                }
            }
            sb.append(result+"\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean dfs(int x, int y) {
        if(!visit[board[x][y]-1]) {
            if(x==1) {
                dfs(0, board[x][y] - 1);
            }
            else {
                visit[board[x][y]-1] = true;
                dfs(1,y);
            }

            return true;
        }

        return false;
    }
}
