import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 부품찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arrN = br.readLine().replace(" ","").toCharArray();
        int M = Integer.parseInt(br.readLine());
        char[] arrM = br.readLine().replace(" ","").toCharArray();

        Arrays.sort(arrN);


        for(int i=0; i<M; i++) {
            int target = arrM[i]-'0';
            int result = binary_search(arrN, target, 0, N-1);

            if(result == -1) System.out.print("no ");
            else System.out.print("yes ");
        }

    }

    private static int binary_search(char[] arrN, int target, int start, int end) {
        while (start<=end) {
            int pivot = (start+end)/2;

            if(arrN[pivot]-'0'<target) start=pivot+1;
            else if(arrN[pivot]-'0'>target) end = pivot-1;
            else return pivot;

        }
        return -1;
    }
}
// 시간복잡도: O((N+M)logN)