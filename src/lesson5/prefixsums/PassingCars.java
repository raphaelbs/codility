package lesson5.prefixsums;

import utils.IExecuter;
import utils.Log;

public class PassingCars {

	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(new int[] { 0, 1, 0, 1, 1 });
			}
		});
		
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(new int[] { 0, 1, 0, 0, 0, 1, 1 });
			}
		});
	}

	public static int solution(int[] A) {
		int totalSum = 0;
		int[] reverseSum = new int[A.length];
		
		int reverseCurrentSum = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] == 1) {
				reverseSum[i] = ++reverseCurrentSum;
			} else {
				reverseSum[i] = reverseCurrentSum;
			}
		}
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				totalSum += reverseSum[i];
				if (totalSum > 1000000000) {
					return -1;
				}
			}
		}
		
		return totalSum;
	}
}
