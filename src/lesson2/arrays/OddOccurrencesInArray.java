package lesson2.arrays;

import java.util.HashMap;

import utils.IExecuter;
import utils.Log;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(new int[] { 9, 3, 9, 3, 9, 7, 9 });
			}
		});
	}
	
	public static int solution(int[] A) {
		HashMap<Integer, Boolean> dic = new HashMap<>();
	    for (int i = 0; i < A.length; i++) {
	    	int index = A[i];
	        if (dic.get(index) != null) {
	        	dic.remove(index);
	        } else{
	        	dic.put(index, true);
	        }
	    }
	    return (int) dic.keySet().toArray()[0];
	}
}
