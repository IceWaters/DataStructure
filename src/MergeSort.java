import Util.ArrayUtil;

public class MergeSort {
	int[] array = {};
	int[] temp = {};
	
	public static void main(String[] args){
		int[] array = new int[]{38, 49, 87, 109, 48, 19, 38, 1, 90, 87, 36, 81};
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(array);
		ArrayUtil.print(array);
		
	}
	public int[] mergeSort(int[] array){
		this.array = array;
		this.temp = new int[array.length];
		mergeSortRec(0, array.length - 1);
		return this.array;
	}
	
	private void mergeSortRec(int start, int end){
		if(start == end)
			return ;
		else{
			int middle = (start + end) / 2;
			mergeSortRec(start, middle);
			mergeSortRec(middle + 1, end);
			merge(start, middle, end);
		}
	}
	
	private void merge(int start, int middle, int end) {		
		int i, j, k;
		for(i = start, j = middle + 1, k = start; i <= middle && j <= end; k++){
			if(array[i] > array[j])
				temp[k] = array[j++];
			else
				temp[k] = array[i++];
		}
		while(i <= middle)
			temp[k++] = array[i++];
		while(j <= end)
			temp[k++] = array[j++];
		
		for(i = start; i <= end; i++){
			array[i] = temp[i];
		}
	}
}
