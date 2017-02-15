package Util;

public class ArrayUtil {
	int[] array;
	
	public ArrayUtil(int[] array){
		this.array = array;
	}
	
	/**
	 * 打印数组
	 */
	public static void  print(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
