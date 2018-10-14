import java.util.*;

/**
 * 优化的元素查找
 */
class FindTheOptimal {
	public static void main(String[] args) {
		
		int[] a = {4, 2, 3, 5, 9, 6};
		
		int result = find(a, 6);
		
		System.out.println(result);
		
	}

	
	static int find(int[] a, int key) {
		
		int n = a.length;
		
		if (a == null || n <= 0) {
			return -1;
		}		
		
		if (a[n-1] == key) {
			return n-1;
		}
		
		int tmp = a[n-1];
		
		a[n-1] = key;
		
		int i = 0;
		
		while (a[i] != key) {
			++i;
		}
		
		a[n-1] = tmp;
		
		if (i == n-1) {
			return -1;
		} else {
			return i;
		}
		
	}
	
}