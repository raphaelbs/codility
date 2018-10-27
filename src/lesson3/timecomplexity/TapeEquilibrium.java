package lesson3.timecomplexity;

import utils.IExecuter;
import utils.Log;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 * @author Raphael Brandão
 */
public class TapeEquilibrium {

	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(new int[] {3, 1, 2, 4, 3});
			}
		});
	}
	
	 public static int solution(int[] A) {
        int[] reverseArray = new int[A.length];
        int currentSum = 0;
        
        for (int i=A.length-1; i>=0; i--) {
            currentSum += A[i];
            reverseArray[i] = currentSum;
        }
        
        currentSum = A[0];
        int minimumSum = Integer.MAX_VALUE;
        for (int i=1; i<A.length; i++) {
            int diff = Math.abs(currentSum - reverseArray[i]);
            if (diff < minimumSum) {
                minimumSum = diff;
            }
            currentSum += A[i];
        }
        
        return minimumSum;
    }
	
}
