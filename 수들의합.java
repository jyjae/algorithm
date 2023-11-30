import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;

        while (end!=n) {
            if(sum == n) {
                count++;
                end++;
                sum = sum+end;
            } else if(sum < n) {
                end++;
                sum += end;
            } else if(sum > n) {
                sum -= start;
                start++;
            }

        }

        System.out.println(count);
    }
}
