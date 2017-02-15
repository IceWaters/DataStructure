import Util.ArrayUtil;

public class InsertSort {
	public static void main(String[] args){
		int[] array = new int[]{38, 49, 87, 109, 48, 19, 38, 1, 90, 87};
		InsertSort insertSort = new InsertSort();
		//array = insertSort.straightInsertSort(array);
		array = insertSort.shellInsertSort(array);
		ArrayUtil.print(array);
//		System.out.println(array);
	}
	
	/**
	 * 直接插入排序       
	 *        
	 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
	 * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。        
	 * 
	 * @param array 需要排序的数组
	 * @return
	 */
	public int[] straightInsertSort(int[] array){
		for(int i = 1; i < array.length; i++){
			//对数组中的第i个数字进行插入排序
			int x = array[i];
			if(x > array[i - 1])
				continue;
			for(int j = 0; j < i; j++){
				//遍历已排序的部分
				if(array[j] > x){
					for(int k = i; k > j; k--){
						array[k] = array[k - 1];//元素后移
					}
					array[j] = x;
					break;
				}
			}
		}
		return array;
	}
	
	/**
	 * 希尔排序
	 * 操作方法：
	 * 	1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；一般取{n/2 ,n/4, n/8 .....1} n为要排序数的个数
	 * 	2.按增量序列个数k，对序列进行k趟排序；
	 * 	3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
	 * 	      仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
	 * 
	 * @param array 需要排序的数组
	 * @return
	 */
	public int[] shellInsertSort(int[] array) {
		int increment = array.length / 2;
		while(increment >= 1){
			array = shellInsertSort(array, increment);
			increment = increment / 2;
		}
		return array;
	}
	
	/**
	 * 
	 * @param array 需要排序的数组
	 * @param increment 增量
	 * @return
	 */
	private int[] shellInsertSort(int[] array, int increment){
		for(int i = 0; i < increment; i++){
			for(int k = i + increment; k < array.length; k = k + increment){
				int x = array[k];
				if(x > array[k - increment])
					continue;
				for(int j = i; j < k; j = j + increment){
					//遍历已排序的部分
					if(array[j] > x){
						for(int m = k; m > j; m = m - increment){
							array[m] = array[m - increment];//元素后移
						}
						array[j] = x;
						break;
					}
				}
			}
		}
		return array;
	}
}
