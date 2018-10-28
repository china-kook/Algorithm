/**
 * 二分查找算法，包括非递归实现和递归实现，以及常见的变体
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
     * 
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

    /**
     * 变体一：查找第一个值等于给定值的元素
     * 
     * 第一种实现方法，非常烧脑，难理解，但是代码简洁
     * 
     * @param arr
     * @param value
     * @return
     */
    public static int bsearchToVariant1(int[] arr, int value) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (arr[low] == value) {
            return low;
        } else {
            return -1;
        }
    }

    /**
     * 变体一：查找第一个值等于给定值的元素
     * 
     * 第二种实现方式，较容易理解
     * 
     * @param arr
     * @param value
     * @return
     */
    public static int bsearchToVariant1s(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}