package lesson4.countingelements;

import utils.IExecuter;
import utils.Log;

public class MissingInteger {

	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(new int[] { 1, 3, 6, 4, 2 });
			}
		});
	}
	
	public static int solution(int[] A) {
		boolean[] found = new boolean[1000001];
		for (int a : A) {
			if (a > 0)
				found[a] = true;
		}
		for (int i = 1; i < found.length; i++) {
			if (!found[i])
				return i;
		}
		return 1;
	}

}
