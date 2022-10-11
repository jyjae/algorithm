import java.util.Arrays;

/*
    데이터가 무작위로 여러 개 있을 때, 이중에서 가장 작은 데이터를 선택하여 맨 앞에 있는 데이터와 바꾸고,
    그 다음 작은 데이터를 선택해 두 번째 데이터와 바꾸는 과정
 */
public class 선택정렬 {
    public static void main(String[] args) {
        int[] arr = {5,6,2,3,4,8,1,10,9};

        for(int i=0; i<arr.length; i++) {
            int minIdx = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j]<arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
// 시간복잡도: O(N^2)