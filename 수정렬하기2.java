import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        for(int i=0; i<n; i++) {
            arr[Integer.parseInt(br.readLine())] =1;
        }

        for (int i=0; i<arr.length; i++) {
            if(arr[i]!=0) {
                System.out.println(i);
            }
        }
    }
}
