import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.prefs.BackingStoreException;

public class 큰수의법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;

        Integer[] arr = new Integer[M];
        st = new StringTokenizer(br.readLine());


        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        int j=0;
        while (N!=0) {
            for(int i=0; i<K;i++) {
                if(N==0) {
                    break;
                }
                answer+=arr[j];
                N--;
            }
            j++;
        }

        System.out.println(answer);
    }
}
