import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int[] scoville, int K) {
        List<Integer> scovilleList = new ArrayList<>();
        for (int s : scoville) {
            scovilleList.add(s);
        }

        MinHeap heap = new MinHeap(null, scovilleList);
        int shakeCount = 0;

        while (true) {
            Integer least = heap.pop();
            if (least == null || least >= K) {
                break;
            }

            Integer leastSecond = heap.pop();
            if (leastSecond == null) {
                return -1;
            }

            int newScovile = least + (leastSecond * 2);
            heap.insert(newScovile);
            shakeCount++;
        }
        return shakeCount;
    }

    private static class MinHeap {
        private List<Integer> heapArray;

        public MinHeap(Integer rootValue, List<Integer> rootValues) {
            heapArray = new ArrayList<>();
            heapArray.add(null); // Placeholder for the 0th index
            if (rootValue != null) {
                heapArray.add(rootValue);
            }
            for (Integer value : rootValues) {
                insert(value);
            }
        }

        public void insert(int value) {
            heapArray.add(value);
            int valueIndex = heapArray.size() - 1;
            int parentIndex = valueIndex / 2;

            while (isNeedSwapUp(parentIndex, valueIndex)) {
                int temp = heapArray.get(valueIndex);
                heapArray.set(valueIndex, heapArray.get(parentIndex));
                heapArray.set(parentIndex, temp);

                valueIndex = parentIndex;
                parentIndex = valueIndex / 2;
            }
        }

        private boolean isNeedSwapUp(int parentIdx, int valueIdx) {
            if (parentIdx < 1) {
                return false;
            }
            return heapArray.get(valueIdx) < heapArray.get(parentIdx);
        }

        public Integer pop() {
            if (heapArray.size() <= 1) {
                return null;
            }
            int root = heapArray.get(1);
            int lastValueIdx = heapArray.size() - 1;
            int lastValue = heapArray.get(lastValueIdx);

            heapArray.remove(lastValueIdx);
            if (heapArray.size() > 1) {
                heapArray.set(1, lastValue);
            }

            int valueIndex = 1;
            while (true) {
                int swapTargetIndex = getSwapTargetIndex(valueIndex);
                if (swapTargetIndex == -1) {
                    break;
                }
                int temp = heapArray.get(valueIndex);
                heapArray.set(valueIndex, heapArray.get(swapTargetIndex));
                heapArray.set(swapTargetIndex, temp);

                valueIndex = swapTargetIndex;
            }
            return root;
        }

        private int getSwapTargetIndex(int valueIndex) {
            int leftChildIndex = valueIndex * 2;
            int rightChildIndex = leftChildIndex + 1;
            boolean hasLeftChild = leftChildIndex < heapArray.size();
            boolean hasRightChild = rightChildIndex < heapArray.size();

            if (!hasLeftChild) {
                return -1;
            }

            if (hasLeftChild && !hasRightChild) {
                if (heapArray.get(valueIndex) > heapArray.get(leftChildIndex)) {
                    return leftChildIndex;
                }
                return -1;
            }

            if (hasLeftChild && hasRightChild) {
                int leftValue = heapArray.get(leftChildIndex);
                int rightValue = heapArray.get(rightChildIndex);

                if (leftValue <= rightValue && heapArray.get(valueIndex) > leftValue) {
                    return leftChildIndex;
                } else if (rightValue < leftValue && heapArray.get(valueIndex) > rightValue) {
                    return rightChildIndex;
                }
            }
            return -1;
        }
    }
}
