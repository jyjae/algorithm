
import java.util.Scanner;

public class 볼링공고르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr1 = new int[N+1];
        int[] arr2 = new int[M+1];

        for(int i=1; i<=N; i++) {
            int a = sc.nextInt();
            arr1[i] = a;
            arr2[a]++;
        }
        int sum =0;

        for(int i=1; i<=N; i++) {
            sum += N-i-(arr2[arr1[i]]-1);
            arr2[arr1[i]]--;
        }

        System.out.println(sum);
    }
}
