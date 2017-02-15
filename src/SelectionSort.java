import Util.ArrayUtil;

/**
 * 选择排序
 * 
 * @author Administrator
 *
 */
public class SelectionSort {
	public static void main(String[] args){
		int[] array = new int[]{38, 49, 87, 109, 48, 19, 38, 1, 90, 87, 36, 81};
		SelectionSort selectionSort = new SelectionSort();
		//array = selectionSort.simpleSelectionSort(array);
		array = selectionSort.heapSort(array);
		ArrayUtil.print(array);
//		System.out.println(array);
	}

	
	/**
	 * 简单选择排序
	 * 
	 * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；
	 * 然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，
	 * 依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
	 * 
	 * @param array	需要排序的数组
	 * @return 	已排序的数组
	 */
	public int[] simpleSelectionSort(int[] array){
		for(int i = 0; i < array.length; i++){
			//找出第i个数字到最后一个数组的最小值
			int key = i;
			for(int j = i; j < array.length; j++){
				//找出最小值
				if(array[key] > array[j])
					key = j;
			}
			//交换位置
			int temp = array[i];
			array[i] = array[key];
			array[key] = temp;
		}
		return array;
	}
	
	/**
	 * 堆排序
	 * 
	 * 
	 * @param array
	 * @return
	 */
	public int[] heapSort(int[] array){
		array = buildHeap(array);//初始堆
		int end = array.length - 1;
		while(end > 0){
			//调换堆顶的元素与尾部元素的位置
			int temp = array[0];
			array[0] =array[end];
			array[end] = temp;
			end--;
			array = adjustHeap(array, 0, end);
		}
		return array;
	}
	
	/**
	 * 初始堆
	 * @param array
	 * @return
	 */
	private int[] buildHeap(int[] array){
		for(int i = (array.length - 1)/ 2; i >= 0; i--){
			array = adjustHeap(array, i, array.length - 1);
		}
		return array;
	}
	
	/**
	 * 调整大顶堆的方法
	 * 
	 * @param array
	 * @param index
	 * @param end
	 * @return
	 */
	private int[] adjustHeap(int[] array, int index, int end){
		if(2 * index + 2 <= end){
			//如果节点的左右子节点都存在
			int leftChild = array[2 * index + 1];
			int rightChild = array[2 * index + 2];
			if(leftChild >= rightChild && array[index] < leftChild){
				//左子节点较大
				array[2 * index + 1] = array[index];
				array[index] = leftChild;
				array = adjustHeap(array, 2 * index + 1, end);
			}
			if(rightChild >= leftChild && array[index] < rightChild){
				//右子节点较大
				array[2 * index + 2] = array[index];
				array[index] = rightChild;
				array = adjustHeap(array, 2 * index + 2, end);
			}
		}else if(2 * index + 1 <= end){
			//仅节点的左子节点存在
			int leftChild = array[2 * index + 1];
			if(array[index] < leftChild){
				array[2 * index + 1] = array[index];
				array[index] = leftChild;
				array = adjustHeap(array, 2 * index + 1, end);
			}
		}
		return array;
	}
}