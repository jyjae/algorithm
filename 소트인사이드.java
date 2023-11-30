import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int n = arr.length;

        for(int i=-1; i<n-2; i++) {
            int head = i+1;
            int maxIndex = i+1;
            for(int j = i+1; j<n; j++) {
                if(arr[maxIndex]-'0' < arr[j] - '0') {
                    maxIndex = j;
                }
            }

            char tmp = arr[head];
            arr[head] = arr[maxIndex];
            arr[maxIndex] = tmp;
        }

       StringBuffer sb = new StringBuffer();
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
        }

        System.out.println(sb.toString());

    }
}
