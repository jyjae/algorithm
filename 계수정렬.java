import java.util.Arrays;

/*
    계수 정렬은 데이터의 크기가 한정되어 있고, 데이터의 크기가 많이 중복되어 있을 때 사용
 */
public class 계수정렬 {
    public static void main(String[] args) {
        int[] arr = {5,6,2,3,4,8,1,10,9};
        int[] arr2 = new int[Arrays.stream(arr).max().getAsInt()+1];

        for(int i=0; i<arr.length; i++) {
            arr2[arr[i]]++;
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i]; j++) {
                System.out.println(i);
            }
        }
    }
}
/*
    데이터 개수: N, 최대값 크기: K
    시간복잡도: O(N+K)
 */
