import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];

        d[1] =0;
        d[2] =1;
        d[3] =1;
        d[4] =2;
        d[5] =1;

        System.out.println(topdown(d, N));
    }

    public static int topdown(int[] d, int x) {
        int[] a = new int[4];

        if(x<=1) {
            return 0;
        }

        if(d[x]!=0) return d[x];
        if(x%5==0) {
            a[0]=topdown(d, x/5)+1;
        }
        if(x%3==0) {
            a[1]=topdown(d, x/3)+1;
        }
        if(x%2==0) {
            a[2]=topdown(d, x/2)+1;
        }
        a[3] = topdown(d, x-1)+1;

        int min = Integer.MAX_VALUE;

        for(int i=0; i<a.length; i++) {
            if(min>a[i] && a[i]!=0) {
                min = a[i];
            }
        }

        d[x] = min;

        return d[x];
    }

}
