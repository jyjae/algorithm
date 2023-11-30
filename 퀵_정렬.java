import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 퀵_정렬 {
    public static void main(String[] args) {

        int[] arr = new int[]{49,97,53,5,33,65,62,51};
        qsort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void qsort(int[] arr, int start, int end) {
        if(start>=end) return;

        int pivot = arr[start];
        int lo = start+1;
        int hi = end;

        while (lo<=hi) {
            while (lo<=end && arr[lo] < pivot) {
                lo++;
            }
            while (start<hi && arr[hi]>pivot) {
                hi--;
            }

            if(lo>hi) {
                int tmp = arr[hi];
                arr[hi] = pivot;
                arr[start]= tmp;
            } else {
                int tmp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi]= tmp;
            }
        }

        qsort(arr, start, hi-1);
        qsort(arr, hi+1, end);
    }
}
