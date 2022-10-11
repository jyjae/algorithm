import java.util.Arrays;

public class 퀵정렬 {
    public static void main(String[] args) {
        int[] arr = {5,6,2,3,4,8,1,10,9};
        recursive(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void recursive(int[] arr, int start, int end) {
        if (start >= end) return; // 원소가 1일때 return
        int pivot = start;
        int left = start+1;
        int right = end;
        while (left<=right) {
            // 왼쪽에서부터 피벗보다 큰 수를 구한다.
            while (left<=end && arr[left]<=arr[pivot]) left++;
            // 오른쪽에서부터 피봇보다 작은 수를 구한다.
            while (right>start && arr[right]>=arr[pivot]) right--;

            // 엇갈렸다면 작은수(right)와 pivot swap한다.
            if(left>right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        recursive(arr,start, right-1);
        recursive(arr,right+1, end);
    }
}
