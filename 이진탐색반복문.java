public class 이진탐색반복문 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,6,7,9,10};
        int target = 7;

        int start = 0;
        int end = arr.length-1;

        while (start<=end) {
            int pivot = (start+end)/2;

            if(arr[pivot]<target) {
                start = pivot+1;
            }else if(arr[pivot]>target) {
                end = pivot-1;
            }else {
                System.out.println(pivot);
                break;
            }
        }
    }
}
