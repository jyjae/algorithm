import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 모험가길드 {
    public int Solution(int num, Integer[] arr) {
        Arrays.sort(arr);

        int gongpo = Integer.MIN_VALUE;
        int cnt = 0;
        int result = 0;

        for(int i=0; i<arr.length; i++) {
            cnt++;
            if(gongpo<arr[i]) {
                gongpo = arr[i];
            }
            if(gongpo-cnt == 0) {
                cnt = 0;
                result++;
                gongpo = Integer.MIN_VALUE;
            }
        }
            return result;
    }

    public static void main(String[] args) throws IOException {
        모험가길드 solution = new 모험가길드();
        System.out.println(solution.Solution(5,new Integer[]{2,3,1,2,2,2,1,4}));
    }
}
