package lesson4.countingelements;

import java.util.HashMap;

import utils.IExecuter;
import utils.Log;

public class FrogRiverOne {

	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 });
			}
		});
	}
	
	public static int solution(int X, int A[]) {
		HashMap<Integer, Boolean> dic = new HashMap<>(X);
		
		for (int i = 1; i <= X; i++) {
			dic.put(i, true);
		}
		
		for (int i = 0; i < A.length; i++) {
			dic.remove(A[i]);
			if (dic.size() == 0) {
				return i;
			}
		}
		
		return -1;
	}

}
