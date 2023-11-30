import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<n-1; i++) {
            boolean isChanged = false;
            for(int j=0; j<n-1-i; j++) {
                if(arr[j]>arr[j+1]) {
                    isChanged = true;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }

            if(!isChanged) {
                break;
            }
        }

        for (int i=0; i<n; i++) {
            System.out.println(arr[i]);
        }
    }
}
