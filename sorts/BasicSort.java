
/**
 * 基础的排序算法：冒泡排序、插入排序、选择排序
 * 
 * @author ikook
 */
public class BasicSort {

    /**
     * 冒泡排序
     * 
     * @param arr
     */
    public static void bubbleSort(int[] arr) {

        // 数组的长度
        int n = arr.length;

        // 数据长度小于等于 1 无需排序
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            // 提前退出排序的标志位
            boolean flag = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < a[j]) { // 比较
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = true; // 此次冒泡有数据交换
                }
            }

            if (!flag) {
                break; // 没有数据交换，提前退出
            }

        }

    }

    /**
     * 插入排序
     * 
     * @param arr
     */
    public static void insertionSort(int[] arr) {

        int n = arr.length;

        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {

            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = value;
        }

    }

    /**
     * 选择排序
     * 
     * @param arr
     */
    public static void selectionSort(int[] arr) {

        int n = arr.length;

        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < n; i++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if(minIndex == i) {
                continue;
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

    }

}