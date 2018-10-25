
/**
 * 快速排序算法
 * 
 * @author ikook
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        int n = arr.length;
        quickSortInternally(arr, 0, n - 1);
    }

    // 递归函数
    public static void quickSortInternally(int[] arr, int p, int r) {

        if (p >= r) {
            return;
        }

        // 获取分区点
        int q = partition(arr, p, r);

        quickSortInternally(arr, p, q - 1);
        quickSortInternally(arr, q + 1, r);

    }

    // 分区函数
    public static int partition(int[] arr, int p, int r) {

        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
            }
        }

        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        return i;
    }

}