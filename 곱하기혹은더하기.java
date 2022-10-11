import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱하기혹은더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int answer = arr[0]-'0';
        int right = 1;

        while(right<arr.length) {
            if(answer>=2 && arr[right]-'0'>2) {
                answer*=(arr[right]-'0');
            }else {
                answer +=(arr[right]-'0');
            }
            right++;
        }
        System.out.println(answer);
    }
}
