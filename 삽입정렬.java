import java.util.Arrays;

/*
    삽입 정렬은 특정한 데이터를 적절한 위치에 삽입한다는 의미에서 삽입 정렬이라고 부른다.
    만약 정렬이 거의 되어 있는 상황에서는 퀵 정렬 알고리즘보다 더 강력하다.
 */
public class 삽입정렬 {
    public static void main(String[] args) {
        int[] arr = {5,6,2,3,4,8,1,10,9,111};

        for(int i =0; i<arr.length; i++) {
            int targetIdx = i;
            for(int j=i; j>=0; j--) {
                if(arr[j]>arr[targetIdx]) {
                    int temp =arr[j];
                    arr[j] = arr[targetIdx];
                    arr[targetIdx] = temp;
                    targetIdx = j;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
// 시간복잡도: O(N^2)
