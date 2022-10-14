import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 효율적인화폐구성 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arrN = new int[N];
        int[] arrK = new int[K+1];

        for(int i=0; i<N; i++) {
            arrN[i] = sc.nextInt();
        }

        Arrays.fill(arrK, 1001);

        arrK[0] =0;
        for(int i=0; i<arrN.length; i++) {
            for(int j = arrN[i]; j<arrK.length; j++) {
                if(arrK[j-arrN[i]]!=1001) {
                    arrK[j] = Math.min(arrK[j], arrK[j - arrN[i]]+1);
                }
            }
        }

        if(arrK[K]==1001) System.out.println(-1);
        else System.out.println(arrK[K]);
    }
}
