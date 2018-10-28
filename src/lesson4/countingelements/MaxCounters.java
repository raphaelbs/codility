package lesson4.countingelements;

import utils.IExecuter;
import utils.Log;

public class MaxCounters {

	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(3, new int[] { 1, 2, 3, 3, 3, 4, 3, 1, 2, 3 });
			}
		});
	}
	
	public static int[] solution(int N, int[] A) {
        int[] counts = new int[N];
        int maxValue = 0;
        IncreaseManager stack = new IncreaseManager(N, maxValue);
        
        for (int i = 0; i < A.length; i++) {
        	if (A[i] == N + 1) {
        		stack = new IncreaseManager(N, maxValue);
        	} else {
        		int index = A[i] - 1;
        		int increase = stack.increaseIndexValue(index);
        		if (increase > 0)
        			counts[index] = increase + 1;
        		else
        			counts[index]++;
        		
        		if (counts[index] > maxValue) {
        			maxValue = counts[index];
        		}
        	}
        }
        
        return stack.finalNormalization(counts);
    }
	
}

class IncreaseManager {
	private boolean[] stack;
	private int maxValue;
	
	public IncreaseManager(int N, int maxValue) {
		stack = new boolean[N];
		this.maxValue = maxValue;
	}
	
	public int increaseIndexValue(int index) {
		if (!stack[index]) {
			stack[index] = true;
			return maxValue;
		}
		return 0;
	}
	
	public int[] finalNormalization(int[] A) {
		for (int i = 0; i < A.length; i++) {
			if (!stack[i]) {
				A[i] = maxValue;
			}
		}
		return A;
	}
}
