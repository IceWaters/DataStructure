import Util.ArrayUtil;

public class RadixSort {

	public static void main(String[] args) {
		int[] array = new int[]{38, 49, 87, 109, 48, 19, 38, 1, 90, 87, 36, 81};
		RadixSort radixSort = new RadixSort();
		radixSort.radixSort(array);
		ArrayUtil.print(array);
	}
	
	/**
	 * 基数排序
	 * 是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
	 * @param array
	 * @return
	 */
	public int[] radixSort(int[] array){
		int max = array[0];
		//由于数字为0-9，故桶的个数为10，且每个桶的第一个数存储该桶中存储数据的个数
		int[][] bucket = new int[10][array.length + 1];
		for(int i = 1; i < array.length; i++)
			//找出最大值，确定排序的次数
			if(array[i] > max)
				max = array[i];
		
		for(int i = 1; i <= max; i = i * 10){
			//先从低位开始排序，然后再到高位
			empty(bucket, array.length + 1);//清空
			for(int j = 0; j < array.length; j++){
				//将数据按照指定位数的数字存入对应的桶中
				int key = (array[j] / i) % 10;
				bucket[key][0]++;
				bucket[key][bucket[key][0]] = array[j];
			}
			//收集数据
			array = collection(array, bucket);	
		}
		return array;
	}
	
	/**
	 * 只需清零桶中的第一个数目，该元素代表了桶中存储数据的数目
	 * @param bucket 需要清零的数据
	 * @param length
	 * @return
	 */
	private int[][] empty(int[][] bucket, int length){
		for(int i = 0; i < 10; i++)
				bucket[i][0] = 0;
		return bucket;
	}
	
	/**
	 * 取出桶中的数据顺序取出来，存储到原来的数组中
	 * @param array
	 * @param bucket  
	 * @return
	 */
	private int[] collection(int[] array, int[][] bucket){
		int count = 0;
		for(int i = 0; i < 10; i++)
			for(int j = 1; j <= bucket[i][0]; j++)
				array[count++] = bucket[i][j];
		return array;
	}
}
