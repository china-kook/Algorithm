
/**
 * 归并排序算法
 * 
 * @author ikook
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        mergeSortInternally(arr, 0, n - 1);
    }

    public static void mergeSortInternally(int[] arr, int p, int r) {

        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取 p 到 r 之间的中间位置 q
        int q = (p + r) / 2;

        // 分治递归
        mergeSortInternally(arr, p, q);
        mergeSortInternally(arr, q + 1, r);

        // 将 arr[p, q] 和 arr[q+1, r] 合并为 arr[p, r]
        merge(arr, p, q, r);
    }

    public static void merge(int[] arr, int p, int q, int r) {

        int i = p;
        int j = q + 1;
        int k = 0;

        // 申请一个大小和 arr[p, r] 一样的数组
        int[] temp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 判读哪个子数组中有剩余数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到 temp 数组中
        while (start <= end) {
            temp[k++] = arr[start++];
        }

        // 将 temp 中的数据拷贝回原数组 arr[p, r]
        for (i = 0; i <= r - p; i++) {
            arr[p + i] = temp[i];
        }
    }

}