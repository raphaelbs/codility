package lesson1.iterations;

import utils.IExecuter;
import utils.Log;

public class BinaryGap {

	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(32);
			}
		});
	}
	
	public static int solution(int N) {
		int maxZeroCount = 0, currentZeroCount = 0;
		
		for (; N % 2 == 0; N = N / 2) {}
		for (; N >= 1; N = N / 2) {
			if (N % 2 == 0) {
				currentZeroCount++;
			} else { 
				maxZeroCount = Math.max(maxZeroCount, currentZeroCount);
				currentZeroCount = 0;
			}
		}
		
		return maxZeroCount;
	}
}
