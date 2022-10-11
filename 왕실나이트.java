import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실나이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int x1 = a.charAt(1)-'0';
        int y1 = a.charAt(0)-'a'+1;

        int result = 0;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};


        for(int i=0; i<2; i++) {
            for(int j=2; j<4; j++) {
                int x = x1+2*dx[i]+dx[j];
                int y = y1+2*dy[i]+dy[j];

                int x2 = x1+2*dx[j]+dx[i];
                int y2 = y1+2*dy[j]+dy[i];

                if(x<=8&&y<=8&&x>=1&&y>=1) {
                    result++;
                }
                if(x2<=8&&y2<=8&&x2>=1&&y2>=1) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
