import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken())+1;
        int m = Integer.valueOf(st.nextToken());
        int[] a = new int[n+1];
        int[] s = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n; i++) {
            a[i] = Integer.valueOf(st.nextToken());
        }
        s[1] = a[1];

        for(int i=2; i<n; i++) {
            s[i] = s[i-1] + a[i];
        }

        StringBuffer sb = new StringBuffer();
        for(int b=0; b<m; b++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.valueOf(st.nextToken());
            int j = Integer.valueOf(st.nextToken());

            sb.append(s[j]-s[i-1]+"\n");
        }

        System.out.println(sb.toString());
    }
}
