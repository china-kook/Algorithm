/**
 * 二分查找算法，包括非递归实现和递归实现
 */
public class BinarySearch {

    /**
     * 非递归实现
     * 
     * @param arr
     * @param value
     * @return
     */
    public static int bsearch(int[] arr, int value) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            // 中间点
            int mid = low + ((high - low) >> 1);

            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 递归实现
     * @param arr
     * @param value
     * @return
     */
    public static int bsearchToRecursive(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        return bsearchToRecursiveInternally(arr, low, high, value);
    }

    public static int bsearchToRecursiveInternally(int[] arr, int low, int high, int value) {

        if (low > high) {
            return -1;
        }

        int min = low + ((high - low) >> 1);

        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return bsearchToRecursiveInternally(arr, mid + 1, high, value);
        } else {
            return bsearchToRecursiveInternally(arr, low, mid - 1, value);
        }
    }

}