/*
    이진탐색: 반으로 쪼개면서 탐색하기
    이진탐색은 배열 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘이다.
    데이터가 무작위일 때는 사용할 수 없지만, 이미 정렬되어 있다면 매우 빠르게 데이터를 찾을 수 있다는 특징이 있다.
    이진 탐색은 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 특징이 있다.

    변수 3개를 사용하는데 탐색하고자 하는 범위의 시작점, 끝점 그리고 중간점이다.

    이진탐색을 구현하는 방법에는 2가지가 있다.
    1. 재귀 함수
    2. 단순 반복문

 */
public class 이진탐색재귀 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,6,7,9,10};
        int target = 7;

        System.out.println(binarySearch(arr, target,0, arr.length-1));
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        if(start>end) return -1;
        int pivot = (start+end)/2;

        if(arr[pivot]>target) return binarySearch(arr,target,0,pivot-1);
        else if(arr[pivot]<target) return binarySearch(arr, target, pivot+1, end);
        else return pivot;
    }
}
/*
    한 번 실행할 때마다 연산 횟수가 반으로 줄어든다.
    시간복잡도: O(logN)
 */