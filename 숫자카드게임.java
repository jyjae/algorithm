import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = Integer.MIN_VALUE;
        int min = 0;
        while (N>0) {
            min = Integer.MAX_VALUE;
            String str = "abcd";

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<M; i++) {
                int k = Integer.parseInt(st.nextToken());
                if(min>k) min = k;
            }

            if(result<min) result = min;
            N--;
        }

        System.out.println(result);
    }
}
