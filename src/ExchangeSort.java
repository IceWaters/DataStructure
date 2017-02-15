import Util.ArrayUtil;

public class ExchangeSort {
	static int[] array = new int[]{38, 49, 87, 109, 48, 19, 38, 1, 90, 87};
	
	public static void main(String[] args){
		ExchangeSort exchangeSort = new ExchangeSort();
		//array = exchangeSort.bubbleSort(array);
		exchangeSort.quickSort(0, array.length - 1);
		ArrayUtil.print(array);
//		System.out.println(array);
	}
	
	/**
	 * 冒泡排序
	 * 
	 * @param array  需要排序的数组
	 * @return
	 */
	public int[] bubbleSort(int[] array){
		int length = array.length - 1;
		for(int i = 0; i < length - 1; i++){
			for(int j = 0; j < length - i - 1; j++){
				if(array[j] > array[j + 1]){
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array; 
	}
	
	/**
	 * 
	 * @param low
	 * @param high
	 */
	public void quickSort(int low, int high){
		if(low < high){
			int keyLoc = partition(low, high);
			quickSort(low, keyLoc - 1);
			quickSort(keyLoc + 1, high);
		}
	}
	
	/**
	 * 
	 * @param low
	 * @param high
	 * @return  
	 */
	private int partition(int low, int high){
		int key = array[low];
		while(low < high){
			//从表的两端向中间扫描
			while(low < high && array[high] >= key)
				high--;
			//将比给定记录值小的记录交换到低端
			array[low] = array[high];
			
			while(low < high && array[low] <= key)
				low++;
			//将比给定记录值大的记录交换到高端
			array[high] = array[low];
		}
		array[low] = key;
		return low;
	}
}
