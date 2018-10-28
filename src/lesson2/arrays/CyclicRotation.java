package lesson2.arrays;

import utils.IExecuter;
import utils.Log;

public class CyclicRotation {

	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(new int[] { 3, 8, 9, 7, 6 }, 3);
			}
		});
	}
	
	public static int[] solution(int[] A, int K) {
		K %= A.length;
	    int[] response = new int[A.length];
	    for (int i = 0; i < A.length; i++) {
	        response[(i + K) % A.length] = A[i];
	    }
	    return response;
	}

}
